package test;

import Rest.CharacterRequest;
import org.testng.annotations.Test;

public class Rest_Test {
    CharacterRequest character = new CharacterRequest();

    @Test
    public void Walter_Wait(){
        character.listing();
        character.Get();

    }
}
