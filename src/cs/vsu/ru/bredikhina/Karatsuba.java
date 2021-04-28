package cs.vsu.ru.bredikhina;

public class Karatsuba {
    public static void main(String[] args) {

        long answer = karatsuba(234, 6789);
        System.out.print("получили:    " + answer + ",  ");
        System.out.println("ожидаемый ответ:  " + 234 * 6789);

        long answer0 = karatsuba(89, 156);
        System.out.print("получили:    " + answer0 + ",  ");
        System.out.println("ожидаемый ответ:  " + 89 * 156);

        long answer1 = karatsuba(1234, 5678);
        System.out.print("получили:    " + answer1 + ",  ");
        System.out.println("ожидаемый ответ:  " + 1234 * 5678);

        long answer2 = karatsuba(123, 456);
        System.out.print("получили:    " + answer2 + ",  ");
        System.out.println("ожидаемый ответ:  " + 123 * 456);

        long answer3 = karatsuba(12345689, 12345689);
        System.out.print("получили:    " + answer3 + ",  ");
        System.out.println("ожидаемый ответ:  " + 12345689l * 12345689l);
    }


    private static long karatsuba(long i, long j) {
        if (i < 10 || j < 10) {
            return i * j;
        }

        double n = Long.toString(i).length();


        long a = (long) (i / Math.pow(10, Math.floor(n / 2d)));
        long b = (long) (i % Math.pow(10, Math.floor(n / 2d)));
        long c = (long) (j / Math.pow(10, Math.floor(n / 2d)));
        long d = (long) (j % Math.pow(10, Math.floor(n / 2d)));

        long first = karatsuba(a, c);

        long second = karatsuba(b, d);

        long third = karatsuba(a + b, c + d);

        return (long) (
                (first * Math.pow(10, Math.floor(n / 2d) * 2)) +
                        ((third - second - first) * Math.pow(10, Math.floor(n / 2))) +
                        second
        );

    }
}
