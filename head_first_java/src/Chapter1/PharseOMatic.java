package Chapter1;

public class PharseOMatic
{
    public static void main(String[] args)
    {
        String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-B", "win-win", "front-end", "web-based", "pervasive",
                "smart", "six-sigma", "critical-path", "dynamic"};
        String[] wordListTwo = {"empowered", "sticky", "valud-added", "oritented", "centric", "distributed", "clustered",
                "branded", "outside-the-box", "postioned", "networked", "focused", "leveraged", "aligned", "targeted", "shared",
                "cooperative", "accelearted"};
        String[] wordListThree = {"process", "tipping-point", "solution", "architecture", "core competency", "strategy", "mindshare",
                "portal", "space", "visions"};

        int lOne = wordListOne.length;
        int lTwo = wordListTwo.length;
        int lThre = wordListThree.length;

        int rand1 = (int)(Math.random() * lOne);
        int rand2 = (int)(Math.random() * lTwo);
        int rand3 = (int)(Math.random() * lThre);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".";

        System.out.println("What we need is a " + phrase);
    }
}
