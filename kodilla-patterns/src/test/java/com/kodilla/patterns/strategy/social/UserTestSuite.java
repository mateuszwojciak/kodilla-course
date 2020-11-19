package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User joe = new Millenials("Joe");
        User jack = new YGeneration("Jack");
        User donald = new ZGeneration("Donald");

        //When
        String joePosting = joe.chosenMedium();
        System.out.println("Joe is posting on: " + joePosting);
        String jackPosting = jack.chosenMedium();
        System.out.println("Jack is posting on: " + jackPosting);
        String donaldPosting = donald.chosenMedium();
        System.out.println("Donald is posting on: " + donaldPosting);

        //Then
        assertEquals("Millenials prefer posting on Facebook.", joePosting);
        assertEquals("Generation Y prefer posting on Twitter.", jackPosting);
        assertEquals("Generation Z prefer posting on Snapchat.", donaldPosting);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User joe = new YGeneration("Joe");
        //When
        String joePosting = joe.chosenMedium();
        System.out.println("Joe is posting on: " + joePosting);
        joe.sharePost(new SnapchatPublisher());
        joePosting = joe.chosenMedium();
        System.out.println("Now Joe prefer different. " + joePosting);
        //Then
        assertEquals("Generation Z prefer posting on Snapchat.", joePosting);

    }
}
