Type=Service
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

'Service module

Sub Process_Globals
Dim PusheUtil As PusheB4AUtil
End Sub
Sub Service_Create
	
End Sub

Sub Service_Start (StartingIntent As Intent)
	Select StartingIntent.Action
		Case "com.google.android.c2dm.intent.RECEIVE" 
			MessageArrived(StartingIntent)
	End Select
End Sub

Sub MessageArrived (pIntent As Intent) 
	Dim JsonMsg As String
	
	JsonMsg = PusheUtil.getPusheJsonMsg(pIntent)
	If JsonMsg <> "" Then
		 'add your code here to deal with JsonMsg
		 ToastMessageShow("Json message is:" & JsonMsg, True)
	End If
End Sub


Sub Service_Destroy

End Sub


