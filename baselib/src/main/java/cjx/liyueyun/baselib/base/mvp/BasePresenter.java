package cjx.liyueyun.baselib.base.mvp;


/**
 * @author caicai
 * @create 2019/9/26
 * @Describe
 */
public class BasePresenter<V extends BaseView, M extends BasModel> {
    protected V mView;
    protected M mModel;

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */

    public void detachView() {
        this.mView = null;
        this.mModel = null;
    }

    /**
     * 绑定model
     */
    public void bindModel(M mModel) {
        this.mModel = mModel;
    }


    /**
     * View是否绑定
     * @return
     */
    public boolean isAttachedView() {
        return mView != null;
    }

    public V getmView() {
        if (!isAttachedView()) throw new RuntimeException("presenter has not attach to view");
        return mView;
    }

    public M getmModel() {
        if (mModel == null) throw new RuntimeException("presenter has not bind model");
        return mModel;
    }
}
