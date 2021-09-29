//
// Created by 叶亮 on 2019/2/12.
//

#ifndef VIDEOPLAY_GLVIDEOVIEW_H
#define VIDEOPLAY_GLVIDEOVIEW_H

#include "../XData.h"
#include "IVideoView.h"

class XTexture;

class GLVideoView:public IVideoView{
public:
    virtual void SetRender(void *win);
    virtual void Render(XData data);
    virtual void makeCurrentSurface(bool f) { fmux.lock(); this->flag = f; fmux.unlock(); };
    virtual void Close();
protected:
    void *view = 0;
    bool flag = false;
    XTexture *txt = 0;
    std::mutex mux;
    std::mutex fmux;
};
#endif //VIDEOPLAY_GLVIDEOVIEW_H
