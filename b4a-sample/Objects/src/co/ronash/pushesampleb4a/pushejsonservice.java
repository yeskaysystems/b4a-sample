package co.ronash.pushesampleb4a;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class pushejsonservice extends android.app.Service {
	public static class pushejsonservice_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, pushejsonservice.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static pushejsonservice mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return pushejsonservice.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "co.ronash.pushesampleb4a", "co.ronash.pushesampleb4a.pushejsonservice");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        processBA.setActivityPaused(false);
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "co.ronash.pushesampleb4a.pushejsonservice", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            BA.LogInfo("** Service (pushejsonservice) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			if (ServiceHelper.StarterHelper.waitForLayout != null)
				BA.handler.post(ServiceHelper.StarterHelper.waitForLayout);
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA))
			handleStart(intent);
		else {
			ServiceHelper.StarterHelper.waitForLayout = new Runnable() {
				public void run() {
                    BA.LogInfo("** Service (pushejsonservice) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (pushejsonservice) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (pushejsonservice) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static co.ronash.pushe.wrapper.PusheWrapper.PusheB4AUtil _pusheutil = null;
public co.ronash.pushesampleb4a.main _main = null;
public co.ronash.pushesampleb4a.starter _starter = null;
public static String  _messagearrived(anywheresoftware.b4a.objects.IntentWrapper _pintent) throws Exception{
String _jsonmsg = "";
 //BA.debugLineNum = 22;BA.debugLine="Sub MessageArrived (pIntent As Intent)";
 //BA.debugLineNum = 23;BA.debugLine="Dim JsonMsg As String";
_jsonmsg = "";
 //BA.debugLineNum = 25;BA.debugLine="JsonMsg = PusheUtil.getPusheJsonMsg(pIntent)";
_jsonmsg = _pusheutil.getPusheJsonMsg((android.content.Intent)(_pintent.getObject()));
 //BA.debugLineNum = 26;BA.debugLine="If JsonMsg <> \"\" Then";
if ((_jsonmsg).equals("") == false) { 
 //BA.debugLineNum = 28;BA.debugLine="ToastMessageShow(\"Json message is:\" & JsonMsg,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Json message is:"+_jsonmsg,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim PusheUtil As PusheB4AUtil";
_pusheutil = new co.ronash.pushe.wrapper.PusheWrapper.PusheB4AUtil();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 16;BA.debugLine="Select StartingIntent.Action";
switch (BA.switchObjectToInt(_startingintent.getAction(),"com.google.android.c2dm.intent.RECEIVE")) {
case 0: {
 //BA.debugLineNum = 18;BA.debugLine="MessageArrived(StartingIntent)";
_messagearrived(_startingintent);
 break; }
}
;
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
