@file:Suppress("UnstableApiUsage")

package ru.webanimal.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import ru.webanimal.lint.rules.ContextInPresenterIssue

class LintRegistry: IssueRegistry() {
    override val issues: List<Issue> = listOf(ContextInPresenterIssue)
    override val api: Int = com.android.tools.lint.detector.api.CURRENT_API
}