package quarkus.bank;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeBankResourceIT extends BankResourceTest {

    // Execute the same tests but in native mode.
}