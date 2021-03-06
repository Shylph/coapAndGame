#ifndef __ROOM_SCROLL_VIEW_H_
#define __ROOM_SCROLL_VIEW_H_
#include "cocos2d.h"
#include "ui/cocosGUI.h"
#include "RoomConfig.h"

class RoomScrollView {
private:
	class FrontHall* superView;
	cocos2d::ui::ScrollView* view;
	std::list<cocos2d::ui::Button*> buttonList;

	cocos2d::ui::Button* createRoomButton(const RoomConfig* roomConfig);
	void onBtnClickListener(cocos2d::Ref* pSender, int roomid);
public:
	RoomScrollView(class FrontHall* layer,cocos2d::Size size);
	void updateRoomConfigs(std::list<RoomConfig*>*  roomList);
	void clearRoomConfigs();
	void setPosition(cocos2d::Vec2 pos) { view->setPosition(pos); }
};

#endif