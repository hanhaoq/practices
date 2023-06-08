package org.example;
import com.google.zxing.Result;
import com.yzk18.commons.IOHelpers;
import com.yzk18.commons.QRCodeHelpers;

import java.util.Arrays;

public class CheckQRcode {
    public static void main(String[] args) {
        String[] files = IOHelpers.getFilesRecursively("D:\\Desktop\\courseTest", "jpg", "png");
        System.out.println(files);
        System.out.println(Arrays.toString(files));
        for (String file : files) {
            Result result = QRCodeHelpers.parseImage(file);
            System.out.println(result);
        }
    }
}
