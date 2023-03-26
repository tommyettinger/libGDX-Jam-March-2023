package com.ray3k.template.data;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.AnimationState.AnimationStateAdapter;
import com.esotericsoftware.spine.AnimationState.TrackEntry;
import com.ray3k.template.*;
import com.ray3k.template.Resources.*;
import com.ray3k.template.screens.*;

public class SkillData {
    public String name;
    public String description;
    public int level = 1;
    public int maxLevel = 10;
    private static final Vector2 temp = new Vector2();
    
    public SkillData() {
    }
    
    public SkillData(SkillData other) {
        this.name = other.name;
        this.description = other.description;
        this.level = other.level;
        this.maxLevel = other.maxLevel;
    }
    
    public void execute(BattleScreen battleScreen, CharacterData character, Array<Table> tiles, Table target, Runnable runnable) {
        var stage = battleScreen.stage;
        var targetTiles = selectTiles(tiles, target);
        
        switch (name) {
            case "punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrike.skeletonData, SpineStrike.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "heavy punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scratch head":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "grumble":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastPink.skeletonData, SpineBlastPink.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastPink.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "charge":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUpRed.skeletonData, SpineStrikeUpRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUpRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "slap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeLeft.skeletonData, SpineStrikeLeft.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeLeft.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tickle":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastPink.skeletonData, SpineBlastPink.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastPink.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "headbutt":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUp.skeletonData, SpineStrikeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scratch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashx3.skeletonData, SpineSlashx3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashx3.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "leap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSpark.skeletonData, SpineSpark.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSpark.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "cat-nap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastWhite.skeletonData, SpineBlastWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "cat-nip":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashBrown.skeletonData, SpineSplashBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "meow":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastWhite.skeletonData, SpineBlastWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "stalk":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "hairball":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionBrown.skeletonData, SpineExplosionBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bite":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBite.skeletonData, SpineBite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scoop":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionPink.skeletonData, SpineExplosionPink.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionPink.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "ice-scream":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pistachio":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGreen.skeletonData, SpineStrikeGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "yogurt":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashWhite.skeletonData, SpineSplashWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "sherbert":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashPurple.skeletonData, SpineSplashPurple.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashPurple.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "banana sundae":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionYellow.skeletonData, SpineExplosionYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "choco syrup":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionBrown.skeletonData, SpineExplosionBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "free samples":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastBlue.skeletonData, SpineBlastBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "ice cream social":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealth.skeletonData, SpineHealth.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealth.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "snowball":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionBlue.skeletonData, SpineExplosionBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "icicle":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeBlue.skeletonData, SpineStrikeBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "freeze ray":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotBlue.skeletonData, SpineShotBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "patented ice cube system":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalBlue.skeletonData, SpinePortalBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "slide":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeLeft.skeletonData, SpineSwipeLeft.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeLeft.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "ice-clone":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashBlue.skeletonData, SpineSplashBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "round-house kick":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRight.skeletonData, SpineStrikeRight.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRight.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "grapple":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineInfinityBrown.skeletonData,
                            SpineInfinityBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineInfinityBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "combo":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikex3.skeletonData, SpineStrikex3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikex3.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "finisher":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeDown.skeletonData, SpineStrikeDown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeDown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "hook":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeLeft.skeletonData, SpineStrikeLeft.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeLeft.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "uppercut":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashWhiteUp.skeletonData, SpineSlashWhiteUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashWhiteUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "triple kick":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikex3.skeletonData, SpineStrikex3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "lunge":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGray.skeletonData, SpineStrikeGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "parry":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShieldYellow.skeletonData, SpineShieldYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShieldYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "riposte":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashWhite.skeletonData, SpineSlashWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "advance":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeUp.skeletonData, SpineSwipeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "retreat":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeDown.skeletonData, SpineSwipeDown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeDown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pirouette":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dagger throw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotRed.skeletonData, SpineShotRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.0f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "blast":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShot.skeletonData, SpineShot.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShot.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "covering fire":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShot.skeletonData, SpineShot.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShot.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "snipe":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShot.skeletonData, SpineShot.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShot.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "burst fire":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShot3.skeletonData, SpineShot3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShot3.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "grenade":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tripwire":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pistol-whip":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrike.skeletonData, SpineStrike.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "shotgun":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotgun.skeletonData, SpineShotgun.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotgun.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "flame bolt":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurn.skeletonData, SpineBurn.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBurn.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "fire-ball":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "lightning strike":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineLightning.skeletonData, SpineLightning.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineLightning.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "siphon filter":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealthRed.skeletonData, SpineHealthRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealthRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "contort":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalRed.skeletonData, SpinePortalRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "blaspheme":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalBlue.skeletonData, SpinePortalBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "plasma beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikePurple.skeletonData, SpineStrikePurple.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikePurple.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "energy sword":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashYellow.skeletonData, SpineSlashYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "fly":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeUp.skeletonData, SpineSwipeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "energy blast":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikePurple.skeletonData, SpineStrikePurple.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikePurple.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "key blade":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashYellow.skeletonData, SpineSlashYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "energy staff":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashBlue.skeletonData, SpineSlashBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "flash":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData,
                            SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "flutter":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeUp.skeletonData, SpineSwipeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "nibble":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBiteWhite.skeletonData, SpineBiteWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBiteWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "hop":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeUp.skeletonData, SpineSwipeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "multiply":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastPink.skeletonData, SpineBlastPink.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastPink.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "lob carrot":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastOrange.skeletonData, SpineBlastOrange.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastOrange.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pellet blast":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBloodBrown.skeletonData, SpineBloodBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBloodBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "cute up":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionPink.skeletonData, SpineExplosionPink.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionPink.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "fuzzy":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSparkWhite.skeletonData, SpineSparkWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSparkWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bunny claw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashx3.skeletonData, SpineSlashx3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashx3.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "snuggle":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineInfinityWhite.skeletonData, SpineInfinityWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineInfinityWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "quick punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrike.skeletonData, SpineStrike.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "double punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikex2.skeletonData, SpineStrikex2.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikex2.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dash punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUp.skeletonData, SpineStrikeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "quick dodge":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeDown.skeletonData, SpineSwipeDown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeDown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "phase":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalGreen.skeletonData, SpinePortalGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "speed up":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastWhite.skeletonData, SpineBlastWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "extendo punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUp.skeletonData, SpineStrikeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "grapnel hook":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGray.skeletonData, SpineStrikeGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "smoke pellet":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "caltrops":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotGray.skeletonData, SpineShotGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "gadget crisps":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastOrange.skeletonData, SpineBlastOrange.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastOrange.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "sticky tape":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGray.skeletonData, SpineStrikeGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scanner":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealthRed.skeletonData, SpineHealthRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealthRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "hack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalGreen.skeletonData, SpinePortalGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "nerf":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalRed.skeletonData, SpinePortalRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dupe":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineLightningWhite.skeletonData, SpineLightningWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineLightningWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "crypto":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealth.skeletonData, SpineHealth.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealth.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "fanboy":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "burn":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurn.skeletonData, SpineBurn.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBurn.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tail whip":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRight.skeletonData, SpineStrikeRight.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRight.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "incendiary grenade":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionYellow.skeletonData, SpineExplosionYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "brimstone":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "torch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurn.skeletonData,
                            SpineBurn.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBurn.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "flame shotgun":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotgunOrange.skeletonData, SpineShotgunOrange.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotgunOrange.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "thwack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "compute":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealth.skeletonData, SpineHealth.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealth.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "fuel up":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealthBrown.skeletonData, SpineHealthBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealthBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "acceleron":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalBlue.skeletonData, SpinePortalBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeBlue.skeletonData, SpineStrikeBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "self-destruct":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "gear":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotGray.skeletonData, SpineShotGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bone rattle":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotWhite.skeletonData, SpineShotWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bone throw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastWhite.skeletonData, SpineBlastWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "knee cap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotWhite.skeletonData, SpineShotWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "spinal tap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastYellow.skeletonData, SpineBlastYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "rigor mortis":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalRed.skeletonData, SpinePortalRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dead eye":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashBrown.skeletonData, SpineSplashBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tombstone smack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeWhite.skeletonData, SpineStrikeWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bury":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashBrown.skeletonData, SpineSplashBrown.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashBrown.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "panda paw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGreen.skeletonData, SpineStrikeGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "bamboo shoot":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShotGreen.skeletonData, SpineShotGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShotGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "gobsmack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGreen.skeletonData, SpineBlastGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "snap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlood.skeletonData, SpineBlood.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlood.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "lay down for a bit":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalBlue.skeletonData, SpinePortalBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "throw weight around":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashBlue.skeletonData, SpineSplashBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "panda smash":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "eat":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlood.skeletonData, SpineBlood.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlood.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "line piece":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "j piece":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "l piece":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "square":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tee":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tetros":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionYellow.skeletonData, SpineExplosionYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scrub":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSparkWhite.skeletonData, SpineSparkWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSparkWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "buff":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastBlue.skeletonData, SpineBlastBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "squeeze":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineInfinity.skeletonData,
                            SpineInfinity.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineInfinity.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "rinse":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastBlue.skeletonData, SpineBlastBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "absorb":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineLightningReverseWhite.skeletonData, SpineLightningReverseWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineLightningReverseWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "spatula":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeGray.skeletonData, SpineStrikeGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pie slice":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashWhite.skeletonData, SpineSlashWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "pie graph":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurnGreen.skeletonData, SpineBurnGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "radial menu":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalBlue.skeletonData, SpinePortalBlue.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalBlue.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "circumference":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalRed.skeletonData, SpinePortalRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "radius":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "perimeter":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortal.skeletonData, SpinePortal.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortal.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "chomp":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBite.skeletonData, SpineBite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "crocodile roll":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalGreen.skeletonData, SpinePortalGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tiny arm smack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tail sweep":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeLeft.skeletonData, SpineStrikeLeft.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeLeft.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "thrash":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dino bop":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSplashPurple.skeletonData, SpineSplashPurple.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSplashPurple.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "belly crawl":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeUp.skeletonData, SpineSwipeUp.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeUp.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "shield throw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShieldRed.skeletonData, SpineShieldRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShieldRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "heroic punch":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUpRed.skeletonData, SpineStrikeUpRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUpRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "juice up":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGreen.skeletonData, SpineBlastGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "block":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShield.skeletonData, SpineShield.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShield.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "defend":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShieldYellow.skeletonData, SpineShieldYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShieldYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "deflect":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineShieldYellow.skeletonData, SpineShieldYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineShieldYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "heroic kick":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeRed.skeletonData, SpineStrikeRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "slime slap":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashWhite.skeletonData, SpineSlashWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "divide":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortal.skeletonData, SpinePortal.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortal.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "merge":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortal.skeletonData, SpinePortal.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortal.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "sticky":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurnGreen.skeletonData, SpineBurnGreen.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBurnGreen.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "goo blast":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastWhite.skeletonData, SpineBlastWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "goopicide":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionWhite.skeletonData, SpineExplosionWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "regenerate":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealth.skeletonData, SpineHealth.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealth.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "claw":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashx3.skeletonData, SpineSlashx3.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSlashx3.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "yip":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineLightning.skeletonData, SpineLightning.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineLightning.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "snarl":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastRed.skeletonData,
                            SpineBlastRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "howl":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "trot":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSwipeLeft.skeletonData, SpineSwipeLeft.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSwipeLeft.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "dance":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpinePortalRed.skeletonData, SpinePortalRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpinePortalRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "laser beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUpRed.skeletonData, SpineStrikeUpRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUpRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "concussive beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikeUpGray.skeletonData, SpineStrikeUpGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikeUpGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "focused beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineStrikePurple.skeletonData, SpineStrikePurple.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrikePurple.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "devastating beam":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosion.skeletonData, SpineExplosion.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosion.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "ricochet":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSpark.skeletonData, SpineSpark.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineSpark.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "heat vision":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastRed.skeletonData, SpineBlastRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "poke":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastGray.skeletonData, SpineBlastGray.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastGray.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "scream":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineInfinityWhite.skeletonData, SpineInfinityWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineInfinityWhite.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "rage out":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlood.skeletonData, SpineBlood.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlood.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "rind":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBlastOrange.skeletonData, SpineBlastOrange.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBlastOrange.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "tasty snack":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealth.skeletonData, SpineHealth.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealth.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "vitamin c":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineExplosionYellow.skeletonData, SpineExplosionYellow.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineExplosionYellow.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "crown of thorns":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineHealthRed.skeletonData, SpineHealthRed.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineHealthRed.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "flay and bake":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineBurn.skeletonData, SpineBurn.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineBurn.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            case "slash":
                for (var tile : targetTiles) {
                    var enemy = (CharacterData) tile.getUserObject();
            
                    var spineDrawable = new SpineDrawable(Core.skeletonRenderer, SpineSlashWhite.skeletonData, SpineSlashWhite.animationData);
                    spineDrawable.getAnimationState().setAnimation(0, SpineStrike.animationAnimation, false);
                    spineDrawable.setCrop(-10, -10, 20, 20);
                    battleScreen.spineDrawables.add(spineDrawable);
            
                    Image image = new Image(spineDrawable);
                    image.setTouchable(Touchable.disabled);
                    stage.addActor(image);
            
                    temp.set(76, 51);
                    tile.localToStageCoordinates(temp);
                    image.setPosition(temp.x, temp.y, Align.center);
            
                    spineDrawable.getAnimationState().addListener(new AnimationStateAdapter() {
                        @Override
                        public void complete(TrackEntry entry) {
                            image.remove();
                            battleScreen.spineDrawables.removeValue(spineDrawable, true);
                            if (enemy != null) {
                                int damage = MathUtils.floor(10 * (1 + (float) level / maxLevel * 20.f));
                                enemy.health -= damage;
                                battleScreen.showDamage(tile, enemy, damage);
                                battleScreen.showTextEffectHurt(tile, enemy);
                            }
                            stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(runnable)));
                        }
                    });
                }
                break;
            default:
                stage.addAction(Actions.sequence(Actions.delay(.5f), Actions.run(runnable)));
                break;
        }
    }
    
    public Array<Table> selectTiles(Array<Table> tiles, Table target) {
        var selected = new Array<Table>();
        
        selected.add(target);
        
        return selected;
    }
}
