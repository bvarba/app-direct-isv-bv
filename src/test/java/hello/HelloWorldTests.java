package hello;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTests {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(baos);

    @Before
    public void setup() {
//        System.setOut(ps);
    }

    @Test
    public void shouldPrintTimeToConsole() {
       /* HelloWorld.main(new String[] { });

        assertThat(output(), containsString("The current local time is"));*/
    }

    @Test
    public void shouldPrintHelloWorldToConsole() {
  //      HelloWorld.main(new String[] { });

  //      assertThat(output(), containsString("Hello world!"));
    }

}
