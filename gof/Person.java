package gof;

import java.util.*;

/**
 * <b>Public class Person - Represents an arbitrary person.</b>
 * <p>COMP1161 - Project1</p>
 *
 * @author <h3>Wit Held</p>
 * @version 1.0
 */
public class Person {
    private String lastName;
    private String firstName;
    private char sex;
    protected List<Preference> likes = new ArrayList<Preference>();
    protected List<Preference> dislikes = new ArrayList<Preference>();


    /**
     * <b>Constructor</b>
     * <p>Let's you play God and create a Person.</p>
     *
     * @param lastName  Person's surname
     * @param firstName Person's first name
     * @param sex       Person's sex
     */
    public Person(String lastName, String firstName, char sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
    }

    /**
     * <b>Accessor</b>
     *
     * @return Person's surname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <b>Accessor</b>
     *
     * @return Person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <b>Accessor</b>
     *
     * @return Person's sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * <b>Mutator</b>
     * <p>Adds a preference along with its rating depending on its rating and existence.</p>
     *
     * @param preference Preference to add
     * @param rating     Rating of corresponding preference
     */
    public void addPreference(Preference preference, int rating) {
        // Determine if the rating is valid (-1 or 1)
        boolean valid = (rating == -1 || rating == 1);
        // Determine if preference exists in either states
        boolean exists = (this.likes.contains(preference) || this.dislikes.contains(preference));
        // Mutate relevant list if preference is valid and does not exist
        if (valid && !exists) {
            // Effective use of the Ternary Operator
            Object mutate = (rating == 1) ? this.likes.add(preference) : this.dislikes.add(preference);
        }
    }

    /**
     * <b>Mutator</b>
     * <p>Removes a preference depending on its pre-existence.</p>
     *
     * @param preference Preference to remove
     */
    public void removePreference(Preference preference) {
        // Attempt to remove preference from 'likes' list
        try {
            this.likes.remove(preference);
        } catch (Exception ex) { /*Do nothing*/
        } finally {
            // Attempt to remove preference from 'dislikes' list
            try {
                this.dislikes.remove(preference);
            } catch (Exception ex) { /*Do nothing*/ }
        }
    }

    /**
     * <b>Overrides method in 'java.lang.Object'</b>
     * <p>Outputs formatted Person details</p>
     *
     * @return Formatted string of Person details
     */
    @Override
    public String toString() {
        String s1 = "First Name: " + getFirstName() + "\nLast Name:  " + getLastName();
        String s2 = "\nLIKES:\t\t";
        String s3 = "\nDISLIKES:\t";
        for (Preference like : likes) {
            s2 += like + "\n\t\t\t";
        }
        for (Preference dislike : dislikes) {
            s3 += dislike + "\n\t\t\t";
        }
        return s1 + s2 + s3;
    }

    /**
     * <b>Query a preference for like, dislike, none (1, -1, 0 respectively)</b>
     *
     * @param preference Preference to query
     * @return Rating (-1, 0 or 1)
     */
    public int howDoYouLike(Preference preference) {
        if (this.likes.contains(preference)) {
            return 1;
        } else if (this.dislikes.contains(preference)) {
            return -1;
        } else
            return 0;
    }

    /**
     * <b>Returns compatibility score of/between 'this' and an arbitrary person</b>
     *
     * @param stranger Arbitrary person
     * @return Compatibility score between 'this' person and stranger
     */
    public int compatibility(Person stranger) {
        int numOfCommonLikes = 0, numOfCommonDislikes = 0, numOfDisagreements = 0;
        for (Preference like : this.likes) {
            // Use of the ternary operator to perform mutations
            Object commonLike = (stranger.likes.contains(like)) ? numOfCommonLikes += 1 : null;
            Object disagreements1 = (stranger.dislikes.contains(like)) ? numOfDisagreements += 1 : null;
        }
        for (Preference dislike : this.dislikes) {
            Object commonDislike = (stranger.dislikes.contains(dislike)) ? numOfCommonDislikes += 1 : null;
            Object disagreements2 = (stranger.likes.contains(dislike)) ? numOfDisagreements += 1 : null;
        }
        return (numOfCommonLikes + numOfCommonDislikes) - numOfDisagreements;
    }
}