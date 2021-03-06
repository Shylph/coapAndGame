﻿#ifndef __FRONT_HALL_SCENE_H__
#define __FRONT_HALL_SCENE_H__
#include "cocos2d.h"
#include "RoomConfig.h"

class FrontHall : public cocos2d::Layer
{
private:
	class RoomScrollView* scrollView;
	cocos2d::Label* roomClearLabel;
	void checkResult();
    virtual bool init();
	virtual void onEnter();
	void makeRoomCallback(cocos2d::Ref* pSender);
	std::list<RoomConfig*>* refreshRoom();
	void onKeyPressed(cocos2d::EventKeyboard::KeyCode keyCode, cocos2d::Event * event);
public:
    static cocos2d::Scene* createScene();
    CREATE_FUNC(FrontHall);
	~FrontHall();

	void refreshRoomCallback(cocos2d::Ref* pSender);
};

#endif
