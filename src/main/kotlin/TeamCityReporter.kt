import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.core.Reporter
import java.io.PrintStream

class TeamCityReporter(val out: PrintStream) : Reporter {
    override fun onLintError(file: String, err: LintError, corrected: Boolean) {
        if (!corrected) {
            out.println("##teamcity[inspectionType id='${err.ruleId}' name='Name ${err.ruleId}' description='description not provided>' category='category not provided']")
            out.println("##teamcity[inspection typeId='${err.ruleId}' message='${err.detail}' file='${file}' line='${err.line}' SEVERITY='WARNING']")
        }
    }
}
