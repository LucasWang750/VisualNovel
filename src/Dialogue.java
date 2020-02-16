

public class Dialogue {

    private static String[] text = {"Hey class, just wanted to remind you all that there is a test tomorrow", "I've already arranged study groups for all of you",
            "The teacher points at you, You are with.....", "Dawn", "Eva", "uhhhhh hi", "Who are you again?", "Ugh, I hope you guys dont actually expect me to study",
            "Oh, this is an interesting group huh", "I should ask them about the homework, but who should I ask?"
            ,"Do you understand #3 on the homework?", "Uhh I think so. Let's compare answers.",
            "You look at her assignment. It looks like you guys did the same steps but her final answer is different.", "I think you may have added wrong here.",
            "Oh gosh! I'm so stupid, sorry!", "I can't believe I made such a simple mistake.",
            "Do you understand #3 on the homework?", "I haven't started yet. Did you expect me to start it when it's not even due?"
            , "Do you want help with it?", "I can do it by myself.", "Oh, okay."
            };

    private static String[] nameText = {"", "MC","Eva", "Dawn","Teacher"};


    public static String getText(int i){
        return text[i];
    }

    public static String getNameText(int i){
        return nameText[i];
    }



}
