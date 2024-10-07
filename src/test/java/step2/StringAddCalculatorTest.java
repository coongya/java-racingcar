package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringAddCalculator.*;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
