package com.DeShawnJava;

public class ReverseAString {

    /*
    Learned: How to loop a String that updates itself without
    String Concatenation and while using String-Builder.
     */

    /*
    The following code is a program that inputs a string and returns the same
    string with the only difference is that any word that is 5 or more
    characters in length will be reversed.
     */

    public static String checkToReverse(String sentence) {

        String completedChallenge = "";

        if (sentence.length() > 5) {

            String workingString = sentence;

            String stringRemain = "";
            String stringCreated;

            while (true) {

                StringBuilder challengeString = new StringBuilder();

                if (workingString.contains(" ")) {

                    stringCreated = workingString.substring(0, workingString.indexOf(' '));
                    stringRemain = workingString.substring((workingString.indexOf(' ')) + 1);

                    workingString = stringRemain;

                    if (stringCreated.length() >= 5) {
                        stringCreated = reverse(stringCreated);
                    }

                    challengeString.append(completedChallenge).append(stringCreated).append(" ");

                    completedChallenge = challengeString.toString();

                    /* This part of the code (above) correctly gives the output but it is on separate lines.
                    Specifically each iteration of the loop creates the next part of the sequence of the intended final
                    string but it doesn't output on one line which is desired. --->UPDATE: SOLVED by converting
                    the string-builder to a string (lets call that string: Mirror Copy) and updating the
                    string-builder by passing in Mirror Copy. This allows the string-builder to update itself
                    within the loop and this also avoids and solves string concatenation. (Mirror Copy = completedChallenge)
                     */
                }
                else {
                    String lastString = "";

                    if (stringRemain.length() >= 5) {
                        lastString = reverse(stringRemain);
                    }
                    completedChallenge = completedChallenge + lastString;
                    break;
                }
                completedChallenge = challengeString.toString();

            }
        }
        else {
            System.out.println(sentence);
            return sentence;
        }
        return completedChallenge; // + " :This is the final return line";
    }


    public static String reverse(String willBeReversed) {

        StringBuilder changeOver = new StringBuilder(willBeReversed);

        changeOver = changeOver.reverse();

        String stringReversed = changeOver.toString();

        return stringReversed;
    }
}
