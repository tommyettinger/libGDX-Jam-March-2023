package com.ray3k.template.data;

import com.badlogic.gdx.utils.Array;

public class CharacterData {
    public String name;
    public String description;
    public float health;
    public float healthMax = 100f;
    public int speed;
    public Array<String> skills = new Array<>();
    public Array<String> tags = new Array<>();
    public int position;
    
    public CharacterData() {
    }
    
    public CharacterData(CharacterData other) {
        this.name = other.name;
        this.description = other.description;
        this.health = other.health;
        this.healthMax = other.healthMax;
        this.speed = other.speed;
        skills.addAll(other.skills);
        tags.addAll(other.tags);
    }
    
    public void addTag(String tag) {
        tags.add(tag);
        
        var tagData = GameData.findTag(tag);
        
        healthMax += tagData.healthModifier;
        if (healthMax > 0) health += healthMax;
        
        speed += tagData.speedModifier;
        
        if (tagData.availableSkills.size > 0) {
            skills.add(tagData.availableSkills.first());
            tagData.availableSkills.removeIndex(0);
        }
    }
}
