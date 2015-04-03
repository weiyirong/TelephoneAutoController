package com.android.internal.telephony;
interface ITelephony {
	boolean endCall();

	void answerRingingCall();
	boolean enableDataConnectivity();

    boolean disableDataConnectivity();

    boolean isDataConnectivityPossible();
}
