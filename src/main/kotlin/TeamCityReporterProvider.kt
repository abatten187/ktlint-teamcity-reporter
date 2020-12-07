import com.pinterest.ktlint.core.Reporter
import com.pinterest.ktlint.core.ReporterProvider
import java.io.PrintStream

class TeamCityReporterProvider : ReporterProvider {
    override val id: String = "teamcity"

    override fun get(out: PrintStream, opt: Map<String, String>): Reporter = TeamCityReporter(out)
}
