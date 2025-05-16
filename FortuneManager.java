/**
 * FortuneManager handles the storage and logic of fortune messages.
 * Users can add, remove, and retrieve random fortunes from a list.
 *
 * Author: Alex Sett
 */
package fortuneteller;

import java.util.ArrayList;
import java.util.Random;

public class FortuneManager {
    private ArrayList<String> fortunes;
    private Random rand;

    public FortuneManager() {
        fortunes = new ArrayList<>();
        rand = new Random();// User-provided fortunes
        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you.");
        fortunes.add("Good news will come to you by mail.");
        fortunes.add("You will make a new friend.");
        fortunes.add("A pleasant surprise is in store for you.");
        fortunes.add("You will achieve your goals.");
        fortunes.add("Adventure awaits you this weekend.");
        fortunes.add("You will find what you have been looking for.");
        fortunes.add("Happiness is around the corner.");
        fortunes.add("You will learn something new today.");

// Positive Fortunes
        fortunes.add("You will soon receive good news that will make your heart smile.");
        fortunes.add("You will meet someone who changes your life in the best way.");

// Neutral/Reflective Fortunes
        fortunes.add("Patience is the key to your current challenge.");
        fortunes.add("Sometimes the best answer is to wait.");
        fortunes.add("You’re exactly where you need to be, even if it doesn’t feel like it.");
        fortunes.add("Your journey matters more than the destination.");
        fortunes.add("Listen to your intuition—it’s trying to guide you.");

// Funny or Lighthearted Fortunes
        fortunes.add("You will find something you lost… in the last place you look.");
        fortunes.add("Your future is cloudy… with a chance of meatballs.");
        fortunes.add("Beware of Mondays. They’re never up to any good.");
        fortunes.add("You will soon master the art of doing nothing with great efficiency.");
        fortunes.add("You’ll have a lucky day—unless you step on a LEGO.");
    }

    public String getRandomFortune() {
        if (fortunes.isEmpty()) return "No fortunes available.";
        return fortunes.get(rand.nextInt(fortunes.size()));
    }

    public void addFortune(String fortune) {
        fortunes.add(fortune);
    }

    public void removeFortune(String fortune) {
        fortunes.remove(fortune);
    }

    public ArrayList<String> getAllFortunes() {
        return fortunes;
    }
}