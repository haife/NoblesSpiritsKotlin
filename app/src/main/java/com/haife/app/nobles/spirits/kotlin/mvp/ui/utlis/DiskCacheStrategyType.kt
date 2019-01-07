package com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis

/**
 * @ author haife
 * @ since 2019/1/7
 * TODO：
 */
class DiskCacheStrategyType {

    /**
     * 0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,
     * 2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT
     */
    companion object {
        val All: Int = 0
        val NONE: Int = 1
        val SOURCE: Int = 2
        val RESULT: Int = 3
    }

}