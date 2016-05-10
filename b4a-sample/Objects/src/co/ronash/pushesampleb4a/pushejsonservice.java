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
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "co.ronash.pushesampleb4a", "co.ronash.pushesampleb4a.pushejsonservice");
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
RDebugUtils.currentModule="pushejsonservice";
if (Debug.shouldDelegate("messagearrived"))
	return (String) Debug.delegate(processBA, "messagearrived", new Object[] {_pintent});
String _jsonmsg = "";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub MessageArrived (pIntent As Intent)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim JsonMsg As String";
_jsonmsg = "";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="JsonMsg = PusheUtil.getPusheJsonMsg(pIntent)";
_jsonmsg = _pusheutil.getPusheJsonMsg((android.content.Intent)(_pintent.getObject()));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="If JsonMsg <> \"\" Then";
if ((_jsonmsg).equals("") == false) { 
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="ToastMessageShow(\"Json message is:\" & JsonMsg,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Json message is:"+_jsonmsg,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="pushejsonservice";
if (Debug.shouldDelegate("service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="pushejsonservice";
if (Debug.shouldDelegate("service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="pushejsonservice";
if (Debug.shouldDelegate("service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Select StartingIntent.Action";
switch (BA.switchObjectToInt(_startingintent.getAction(),"com.google.android.c2dm.intent.RECEIVE")) {
case 0: {
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="MessageArrived(StartingIntent)";
_messagearrived(_startingintent);
 break; }
}
;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
}