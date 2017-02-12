package week5.datacompression;

import java.io.ByteArrayOutputStream;

/**
 * Created by matijav on 11/02/2017.
 */
public class Compressor {
    private int R = 16;   // max run-length count
    private int lgR = 4;   // number of bits per count

    public Compressor(int R, int lgR) {
        this.R = R;
        this.lgR = lgR;
    }

    public byte[] compress(byte[] input) {
        validateInput(input);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int run = 0;
        byte previous = 0;
        for (int i = 0; i < input.length; i++) {
            byte b = input[i];
            if (previous != b) {
                writeAsBinary(buffer, run);
                run = 1;
                previous = b;
            } else {
                run++;
            }

            // chunk limit reached; flush
            if (run == R - 1) {
                writeAsBinary(buffer, run);
                run = 0;
                writeAsBinary(buffer, run);   // write 0 since we alternate between 0 and 1
            }
        }

        // flush
        writeAsBinary(buffer, run);

        return buffer.toByteArray();
    }

    public byte[] expand(byte[] input) {
        validateInput(input);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        boolean bit = false;
        int position = 0;
        while (position < input.length) {
            int count = readBytesAsInt(input, position);
            writeBits(buffer, bit, count);    // write bits to buffer

            // reverse bit and in
            bit = !bit;
            position += lgR;
        }
        flush(buffer);       // pad 0s for byte alignment

        return buffer.toByteArray();
    }

    private void validateInput(byte[] input) {
        for (int i = 0; i < input.length; i++) {
            byte b = input[i];
            if (b != 0 && b != 1) {
                throw new InvalidByteException(i, b);
            }
        }
    }

    private void writeBits(ByteArrayOutputStream buffer, boolean bit, int count) {
        for (int i = 0; i < count; i++) {
            buffer.write(bit ? 1 : 0);
        }
    }

    private void flush(ByteArrayOutputStream buffer) {
        int toPad = buffer.size() % lgR;
        if (toPad == 0) {
            return;
        }

        for (int i = 0; i < lgR - toPad; i++) {
            buffer.write(0);
        }
    }

    private void writeAsBinary(ByteArrayOutputStream os, int value) {
        for (int i = lgR - 1; i >= 0; i--) {
            boolean b = (value & (1 << i)) != 0;
            os.write(b ? 1 : 0);
        }
    }

    private int readBytesAsInt(byte[] input, int offset) {
        int val = 0;
        for (int i = 0; i < lgR; i++) {
            val |= input[i + offset] << lgR - i - 1;
        }
        return val;
    }

    public class InvalidByteException extends RuntimeException {
        private int position;
        private byte invalidByte;

        public InvalidByteException(int position, byte invalidByte) {
            this.position = position;
            this.invalidByte = invalidByte;
        }

        @Override
        public String toString() {
            return String.format("Invalid byte %d at position %d", invalidByte, position);
        }
    }
}
