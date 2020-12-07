import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.core.Reporter
import java.io.PrintStream

class TeamCityReporter(val out: PrintStream) : Reporter {
    override fun onLintError(file: String, err: LintError, corrected: Boolean) {
        if (!corrected) {
            val message = "${file}:${err.line}${":${"${err.col}:".let { String.format("%-4s", it) }}"} ${err.detail} (${err.ruleId})"
            out.println("##teamcity[message text='$message' status='FAILURE']")
        }
    }
}
