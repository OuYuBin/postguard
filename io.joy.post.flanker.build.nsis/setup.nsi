 ; Installer for HTML Tidy - March 22, 2008

;======================================================
; Includes
  !define VERSION earlyAccess 
  !define /date TIMESTAMP "%Y%m%d%H%M%S"
  !include MUI.nsh
  !include Sections.nsh
  OutFile "PostFlanker-Installer-${VERSION}-${TIMESTAMP}.exe"
  

;======================================================
; Installer Information

  Name "PostFlanker"

  SetCompressor /SOLID lzma
  XPStyle on
  CRCCheck on
  InstallDir "C:\Program Files\PostFlanker"
  AutoCloseWindow false
  ShowInstDetails show
  Icon "installer.ico"

;======================================================
; Version Tab information for Setup.exe properties

  VIProductVersion 2017.11.11.0
  VIAddVersionKey ProductName "PostFlanker"
  VIAddVersionKey ProductVersion "1.0"
  VIAddVersionKey CompanyName "JD"
  VIAddVersionKey FileVersion "1.0"
  VIAddVersionKey FileDescription ""
  VIAddVersionKey LegalCopyright ""

;======================================================
; Variables


;======================================================
; Modern Interface Configuration

  !define MUI_HEADERIMAGE
  !define MUI_ABORTWARNING
  !define MUI_COMPONENTSPAGE_SMALLDESC
  !define MUI_HEADERIMAGE_BITMAP_NOSTRETCH
  !define MUI_FINISHPAGE
  !define MUI_FINISHPAGE_TEXT "Thank you for installing PostFlanker. \r\n\n\nYou can now run PostFlanker from your command line."
  !define MUI_ICON "installer.ico"
  !define MUI_FINISHPAGE_SHOWREADME ""
  !define MUI_FINISHPAGE_SHOWREADME_NOTCHECKED
  !define MUI_FINISHPAGE_SHOWREADME_TEXT "Create Desktop Shortcut"
  !define MUI_FINISHPAGE_SHOWREADME_FUNCTION finishpageaction

;======================================================
; Modern Interface Pages

  !define MUI_DIRECTORYPAGE_VERIFYONLEAVE
  !insertmacro MUI_PAGE_LICENSE license.txt
  !insertmacro MUI_PAGE_DIRECTORY
  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_INSTFILES
  !insertmacro MUI_PAGE_FINISH

;======================================================
; Languages

  !insertmacro MUI_LANGUAGE "English"

;======================================================
; Installer Sections

Section "PostFlanker"
    SectionIn RO
    SetOutPath $INSTDIR
    SetOverwrite on
    File /r ".\PostFlanker\*.*"

    writeUninstaller "$INSTDIR\uninstall.exe"
SectionEnd


; Installer functions
Function .onInstSuccess

FunctionEnd

Section "uninstall"
  Delete "$desktop\PostFlanker.lnk"
  RMDir /r "$INSTDIR"
SectionEnd

Function finishpageaction
CreateShortcut "$desktop\PostFlanker.lnk" "$instdir\PostFlanker.exe"
FunctionEnd

