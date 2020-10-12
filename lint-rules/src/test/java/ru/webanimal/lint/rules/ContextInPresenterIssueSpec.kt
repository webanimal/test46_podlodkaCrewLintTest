@file:Suppress("UnstableApiUsage")

package ru.webanimal.lint.rules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.java
import com.android.tools.lint.checks.infrastructure.LintDetectorTest.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.android.tools.lint.detector.api.Issue
import io.kotest.core.spec.style.FreeSpec
import org.intellij.lang.annotations.Language

/**
 * @see com.android.tools.lint.checks.infrastructure.LintDetectorTest
 */
class ContextInPresenterIssueSpec: FreeSpec({
    "should report incorrect java import" {
        @Language("java")
        val code = """
            package ru.webanimal.test46podlodkacrewlinttest;

            import android.app.Fragment;
            import android.content.Context;
            import androidx.core.content.ContextCompat;
            import moxy.InjectViewState;
            import moxy.MvpPresenter;
            import moxy.MvpView;
            
            @InjectViewState
            class TextPresenter extends MvpPresenter<MvpView> {
            
                public void onStart(Context context, ContextCompat contextCompat, Fragment appContext) {
                }
            }
        """.trimIndent()

        ContextInPresenterIssue.lintPresenterJavaFile(code)?.expectWarningCount(1)
    }

    "should not report incorrect java import" {
        @Language("java")
        val code = """
            package ru.webanimal.test46podlodkacrewlinttest;

            import moxy.InjectViewState;
            import moxy.MvpPresenter;
            import moxy.MvpView;
            
            @InjectViewState
            class TextPresenter extends MvpPresenter<MvpView> {
            
                public void onStart() {
                }
            }
        """.trimIndent()

        ContextInPresenterIssue.lintPresenterJavaFile(code)?.expectClean()
    }

    "should report incorrect kotlin import" {
        // @Language("kotlin") doesn't recognize word "import"
        @Language("kotlin")
        val code = """
            package ru.webanimal.test46podlodkacrewlinttest

            import android.app.Fragment
            import android.content.Context
            import androidx.core.content.ContextCompat
            import moxy.InjectViewState
            import moxy.MvpPresenter
            import moxy.MvpView
            
            @InjectViewState
            class TestPresenter: MvpPresenter<MvpView>() {
            
                fun onStart(context: Context, contextCompat: ContextCompat, appContext: Fragment) {
                }
            }
        """.trimIndent()

        ContextInPresenterIssue.lintPresenterKtFile(code)?.expectWarningCount(1)
    }

    "should not report incorrect kotlin import" {
        // @Language("kotlin") doesn't recognize word "import"
        @Language("kotlin")
        val code = """
            package ru.webanimal.test46podlodkacrewlinttest

            import moxy.InjectViewState
            import moxy.MvpPresenter
            import moxy.MvpView
            
            @InjectViewState
            class TestPresenter: MvpPresenter<MvpView>() {
            
                fun onStart() {
                }
            }
        """.trimIndent()

        ContextInPresenterIssue.lintPresenterKtFile(code)?.expectClean()
    }
})

fun Issue.lintPresenterJavaFile(file: String) = lint()
    .files(java("java/ru/webanimal/test46podlodkacrewlinttest/example.java", file))
    .allowMissingSdk()
    .issues(this)
    .run()

fun Issue.lintPresenterKtFile(file: String) = lint()
    .files(kotlin("java/ru/webanimal/test46podlodkacrewlinttest/example.kt", file))
    .allowMissingSdk()
    .issues(this)
    .run()