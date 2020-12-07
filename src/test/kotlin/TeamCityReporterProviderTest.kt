
import org.junit.Test
import java.io.PrintStream
import java.lang.System.out

class TeamCityReporterProviderTest {
    @Test
    fun `should get provider`() {
        TeamCityReporterProvider().get(
            out = PrintStream(out, true),
            opt = mapOf()
        )
    }
}
