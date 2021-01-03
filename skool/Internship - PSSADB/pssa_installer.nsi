; Script generated by the HM NIS Edit Script Wizard.
; Modified a lot by  Matthew Evans

; HM NIS Edit Wizard helper defines
!define PRODUCT_NAME "PSSA Student Database"
!define PRODUCT_VERSION "1.0"
!define PRODUCT_PUBLISHER "Forest City Regional School District"
!define PRODUCT_WEB_SITE "http://www.forestcityschool.org/dlap/"
!define PROJECT_DIR "E:\Internship\PSSADB"

SetCompressor bzip2

; MUI 1.67 compatible ------
!include "MUI.nsh"

; MUI Settings
!define MUI_ABORTWARNING
!define MUI_ICON "${NSISDIR}\Contrib\Graphics\Icons\modern-install.ico"
!define MUI_UNICON "${NSISDIR}\Contrib\Graphics\Icons\modern-uninstall.ico"

; Reserve files
!insertmacro MUI_RESERVEFILE_INSTALLOPTIONS

; MUI end ------

Name "${PRODUCT_NAME} ${PRODUCT_VERSION}"
OutFile "PSSADB Setup.exe"
InstallDir "$PROGRAMFILES\PSSA Student Database"
ShowInstDetails show
ShowUnInstDetails show

Section "MainSection" SEC01
  SetOutPath "$INSTDIR"
  SetOverwrite ifnewer
  CreateDirectory "$SMPROGRAMS\PSSA Student Database"
  File "${PROJECT_DIR}\PSSA Database.mdb"
  File "${PROJECT_DIR}\PSSA Student Database.doc"

  SetOutPath "$INSTDIR\help"
  File "${PROJECT_DIR}\help\index.html"
  File "${PROJECT_DIR}\help\forms.html"
  File "${PROJECT_DIR}\help\reports.html"
  File "${PROJECT_DIR}\help\insert.html"
  File "${PROJECT_DIR}\help\fixdb.html"
  
  SetOutPath "$INSTDIR\help\img"
  File "${PROJECT_DIR}\help\img\impdata.jpg"
  File "${PROJECT_DIR}\help\img\mainmenu.jpg"
  File "${PROJECT_DIR}\help\img\mathform.jpg"
  File "${PROJECT_DIR}\help\img\readform.jpg"
  File "${PROJECT_DIR}\help\img\savedrep.jpg"
  File "${PROJECT_DIR}\help\img\saverep.jpg"
  File "${PROJECT_DIR}\help\img\writform.jpg"
  
SectionEnd

Section -AdditionalIcons
  WriteIniStr "$INSTDIR\${PRODUCT_NAME}.url" "InternetShortcut" "URL" "${PRODUCT_WEB_SITE}"
  CreateShortCut "$SMPROGRAMS\PSSA Student Database\Website.lnk" "$INSTDIR\${PRODUCT_NAME}.url"
  CreateShortCut "$SMPROGRAMS\PSSA Student Database\PSSA Student Database.lnk" "$INSTDIR\PSSA Database.mdb"
  CreateShortCut "$SMPROGRAMS\PSSA Student Database\Documentation.lnk" "$INSTDIR\PSSA Student Database.doc"
  CreateShortCut "$DESKTOP\PSSA Student Database.lnk" "$INSTDIR\PSSA Database.mdb"
  CreateShortCut "$SMPROGRAMS\PSSA Student Database\Uninstall.lnk" "$INSTDIR\uninst.exe"
  CreateShortCut "$SMPROGRAMS\PSSA Student Database\PSSA Student Database Help.lnk" "$INSTDIR\help\index.html"
SectionEnd

Section -Post
  WriteUninstaller "$INSTDIR\uninst.exe"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "DisplayName" "${PRODUCT_NAME}"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "UninstallString" "$INSTDIR\uninst.exe"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "DisplayIcon" "$INSTDIR\PSSA Database.mdb"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "DisplayVersion" "${PRODUCT_VERSION}"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "URLInfoAbout" "${PRODUCT_WEB_SITE}"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}" "Publisher" "${PRODUCT_PUBLISHER}"
  
SectionEnd

; Check to see if MS Access 2002 is installed on the computer
Section IsMSAccess2k2Installed
  ClearErrors
  DetailPrint "Checking for MS Access 2002..."
  ReadRegStr $1 HKCR "CLSID\{25377C20-D19C-11D2-B483-00600832C573}" ""
  IfErrors MSAccessIsNotThere MSAccessIsThere
  
  MSAccessIsNotThere:
  
    SetOutPath "$INSTDIR"

    DetailPrint "MS Access 2002 is not installed!"
    MessageBox MB_YESNO "Either Microsoft Access 2002 is not installed on this computer, or you are running an older version of Access.  Setup will now install the MS Access 2002 Runtime.  If you are running an older version of Access, the Rumtime will install over it.  Do you want to continue?" IDNO EndMSAccessCheck
    
    DetailPrint "Extracting the MS Access Runtime Installer..."

    File "${PROJECT_DIR}\Office1.cab"
    File "${PROJECT_DIR}\MSOHELP.EXE"
    File "${PROJECT_DIR}\ACCESSRT.MSI"

    DetailPrint "Done"
    ExecWait "msiexec.exe /i ACCESSRT.MSI"
    
    Delete "$INSTDIR\MSOHELP.EXE"
    Delete "$INSTDIR\ACCESSRT.MSI"
    Delete "$INSTDIR\Office1.cab"
  
  Goto EndMSAccessCheck
  
  MSAccessIsThere:
     DetailPrint "MS Access 2002 is installed"
  
  EndMSAccessCheck:

SectionEnd


Function un.onUninstSuccess
  HideWindow
  MessageBox MB_ICONINFORMATION|MB_OK "${PRODUCT_NAME} was successfully removed from your computer."
FunctionEnd

Function un.onInit
  MessageBox MB_ICONQUESTION|MB_YESNO|MB_DEFBUTTON2 "Are you sure you want to completely remove ${PRODUCT_NAME} and all of its components?" IDYES +2
  Abort
FunctionEnd

Section Uninstall
  ;Delete "$INSTDIR\${PRODUCT_NAME}.url"
  Delete "$INSTDIR\uninst.exe"
  Delete "$INSTDIR\PSSA Database.mdb"
  Delete "$INSTDIR\PSSA Student Database.doc"
  Delete "$INSTDIR\PSSA Student Database.url"
  
  Delete "$INSTDIR\help\index.html"
  Delete "$INSTDIR\help\forms.html"
  Delete "$INSTDIR\help\reports.html"
  Delete "$INSTDIR\help\insert.html"
  Delete "$INSTDIR\help\fixdb.html"
  
  Delete "$INSTDIR\help\img\impdata.jpg"
  Delete "$INSTDIR\help\img\mainmenu.jpg"
  Delete "$INSTDIR\help\img\mathform.jpg"
  Delete "$INSTDIR\help\img\readform.jpg"
  Delete "$INSTDIR\help\img\savedrep.jpg"
  Delete "$INSTDIR\help\img\saverep.jpg"
  Delete "$INSTDIR\help\img\writform.jpg"
  
  Delete "$INSTDIR\MSOHELP.EXE"
  Delete "$INSTDIR\ACCESSRT.MSI"
  Delete "$INSTDIR\Office1.cab"

  Delete "$SMPROGRAMS\PSSA Student Database\Uninstall.lnk"
  Delete "$SMPROGRAMS\PSSA Student Database\Website.lnk"
  Delete "$DESKTOP\PSSA Student Database.lnk"
  Delete "$SMPROGRAMS\PSSA Student Database\PSSA Student Database.lnk"
  Delete "$SMPROGRAMS\PSSA Student Database\PSSA Student Database Help.lnk"
  Delete "$SMPROGRAMS\PSSA Student Database\Documentation.lnk"

  RMDir "$SMPROGRAMS\PSSA Student Database"
  RMDir "$INSTDIR\help\img"
  RMDir "$INSTDIR\help"
  RMDir "C:\PSSATEMP"
  RMDir "$INSTDIR"

  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${PRODUCT_NAME}"
  SetAutoClose true
SectionEnd

