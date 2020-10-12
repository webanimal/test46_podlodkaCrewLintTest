@file:Suppress("UnstableApiUsage")

package ru.webanimal.lint.rules

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiClass
import org.jetbrains.kotlin.utils.addToStdlib.ifNotEmpty
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UImportStatement
import java.util.*

val ContextInPresenterIssue = Issue.Companion.create(
    id = "RulesIdContextInPresenter",
    briefDescription = "Context doesn't allowed in a Presenter scope.",
    explanation = """
        |Presenter shouldn't depends on Android classes and especially depends on Context.
    """.trimMargin(),
    category = Category.Companion.CORRECTNESS,
    priority = 9,
    severity = Severity.ERROR,
    implementation = Implementation(
        ContextInPresenterDetector::class.java,
        Scope.Companion.JAVA_FILE_SCOPE
    )
).setAndroidSpecific(true)

/**
 * @see com.android.tools.lint.checks.WrongImportDetector
 */
class ContextInPresenterDetector: Detector(), SourceCodeScanner {

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return ImportVisitor(context)
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return Collections.singletonList(UImportStatement::class.java)
    }

    companion object {
        val disallowedPackages = listOf(
            "android.content.Context",
            "androidx.core.content.ContextCompat",
            "android.app.Activity",
            "androidx.core.app.ActivityCompat",
            "androidx.appcompat.app.AppCompatActivity",
            "androidx.fragment.app.FragmentActivity",
            "androidx.fragment.app.Fragment",
            "android.app.Fragment"
        )

        const val NON_EQUAL_STRING = "-"

        private class ImportVisitor(val javaContext: JavaContext): UElementHandler() {
           override fun visitImportStatement(node: UImportStatement) {
               // Замечено, что метод вызыввается столько раз, сколько импортов в тестовом файле.
               // Но все "resolved" == null
               val resolved = node.resolve()
               if (resolved is PsiClass) {
                   disallowedPackages.filter {
                       it.contains(resolved.qualifiedName ?: NON_EQUAL_STRING)
                   }.ifNotEmpty {
                       javaContext.report(
                           ContextInPresenterIssue,
                           node,
                           javaContext.getLocation(node),
                           "Don't import <T ? Context> Classes or Classes with Context"
                       )
                   }
               }
           }
        }
    }
}