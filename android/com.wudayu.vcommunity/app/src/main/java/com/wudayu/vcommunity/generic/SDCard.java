package com.wudayu.vcommunity.generic;

import android.os.Environment;
import android.os.StatFs;

import com.wudayu.vcommunity.generic.interfaces.ISDCard;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 28, 2014, 4:23:15 PM
 * @Description: SDCard相关操作实现类
 *
 **/

public class SDCard implements ISDCard {

	/** Generate Singleton */
	private static volatile SDCard instance;

	private SDCard() {}

    public static ISDCard getInstance()
    {
        if (instance == null) {
            synchronized (SDCard.class) {
                if (instance == null) {
                    instance = new SDCard();
                }
            }
        }
        return instance;
    }

	/**
	 * SD卡是否可用
	 * 
	 * @return true->SD卡可用
	 */
	@Override
	public boolean isSdcardAvaliable() {
		return Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}

	/**
	 * SD卡空间是否足够 单位是b
	 * 
	 * @param size
	 *            文件大小
	 * @return true->空间充足
	 */
	@Override
	@SuppressWarnings("deprecation")
	public boolean isAvaiableSpace(long size) {
		boolean ishasSpace = false;
		if (isSdcardAvaliable()) {
			String sdcard = Environment.getExternalStorageDirectory().getPath();
			StatFs statFs = new StatFs(sdcard);
			long blockSize = statFs.getBlockSize();
			long blocks = statFs.getAvailableBlocks();
			long availableSpare = blocks * blockSize;
			if (availableSpare > size) {
				ishasSpace = true;
			}
		} else {
			Utils.debug("SD Card Not Found !");
			return false;
		}
		return ishasSpace;
	}

}
