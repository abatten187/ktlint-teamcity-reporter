import com.pinterest.ktlint.core.LintError
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TeamCityReporterTest {
    @Test
    fun `should show single lint error`() {
        val out = ByteArrayOutputStream()
        val reporter = TeamCityReporter(PrintStream(out, true))

        reporter.onLintError(
            "/MeaningOfLifeBuilder.kt",
            LintError(
                42,
                1,
                "meaning-of-life",
                "This line is the meaning of life"
            ),
            false
        )

        val output = String(out.toByteArray())

        assertEquals(
            output,
            "##teamcity[message text='/MeaningOfLifeBuilder.kt:42:1:   This line is the meaning of life (meaning-of-life)' status='FAILURE']\n"
        )
    }

    @Test
    fun `should not show corrected lint error`() {
        val out = ByteArrayOutputStream()
        val reporter = TeamCityReporter(PrintStream(out, true))

        reporter.onLintError(
            "/CorrectedBuilder.kt",
            LintError(
                42,
                1,
                "corrected-error",
                "This has been corrected"
            ),
            true
        )

        val output = String(out.toByteArray())

        assertEquals(output, "")
    }
}
