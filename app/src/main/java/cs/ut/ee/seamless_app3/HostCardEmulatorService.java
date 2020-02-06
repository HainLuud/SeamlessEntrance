package cs.ut.ee.seamless_app3;

import android.nfc.Tag;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

public class HostCardEmulatorService extends HostApduService {

    private static String TAG = "Host Card Emulator";


    @Override
    public byte[] processCommandApdu(byte[] apdu, Bundle extras) {
        final String STATUS_SUCCESS = "9000";
        final String STATUS_FAILED = "6F00";
        final String CLA_NOT_SUPPORTED = "6E00";
        final String INS_NOT_SUPPORTED = "6D00";
        final String AID = "A0000002471001";
        final String SELECT_INS = "A4";
        final String DEFAULT_CLA = "00";
        final int MIN_APDU_LENGTH = 12;

        Log.d(TAG, "Got apdu request");
        if (apdu == null) {
            return Utils.hexStringToByteArray(STATUS_FAILED);
        }

        String hexCommandApdu = Utils.bytesToHex(apdu);
        Log.d(TAG, hexCommandApdu);
        if (hexCommandApdu.length() < MIN_APDU_LENGTH) {
            return Utils.hexStringToByteArray(STATUS_FAILED);
        }

        if (!hexCommandApdu.substring(0, 2).equals(DEFAULT_CLA)) {
            Log.d(TAG, hexCommandApdu.substring(0, 2));
            return Utils.hexStringToByteArray(CLA_NOT_SUPPORTED);
        }

        if (!hexCommandApdu.substring(2, 4).equals(SELECT_INS)){
            Log.d(TAG, hexCommandApdu.substring(2, 4));
            return Utils.hexStringToByteArray(INS_NOT_SUPPORTED);
        }

        if (hexCommandApdu.substring(10, 24).equals(AID)){
            return Utils.hexStringToByteArray(STATUS_SUCCESS);
        } else {
            return Utils.hexStringToByteArray(STATUS_FAILED);
        }
    }

    @Override
    public void onDeactivated(int reason) {
        Log.d(TAG, "Deactivated: " + reason);
    }
}