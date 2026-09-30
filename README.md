# MeowAw POS (Android APK)

Pet shop POS and inventory app, packaged as an Android app with Capacitor.

## Get the APK
1. Upload every file in this folder to a new GitHub repository (keep the `.github/workflows/build-apk.yml` path exactly).
2. Open the repository's **Actions** tab. The "Build Android APK" workflow runs on each push to `main`. You can also run it with **Run workflow**.
3. When it finishes (about 5 to 8 minutes), open the run and download **MeowAw-POS-debug-apk** from the Artifacts section.
4. Unzip it and copy `app-debug.apk` to your Android phone or tablet, then install it (allow "install unknown apps" when asked).

## Update the app
Edit `www/index.html`, commit, and the workflow builds a new APK.

## Notes
- Data is stored on the device (the app's local storage). It is not shared between devices.
- This is a debug APK, fine for your own devices. Publishing to Google Play needs a signed release build.
- Printing: the Report page's Print button opens the Android print dialog, where you can save a PDF or pick a printer. This uses `native/MainActivity.java` and `native/PrintPlugin.java`, which the build copies into the Android project.
- Download CSV: on the phone it saves through Android's share sheet (save to Files or Drive, or send by Bluetooth or Wi-Fi Direct). It uses the Capacitor Filesystem and Share plugins listed in `package.json`.
- Printers: Wi-Fi and Bluetooth printers appear in Android's print dialog once the printer's print service or app is installed (Settings > Connected devices > Printing).
- App icon: the launcher icons live in `icons/` (made from the round MeowAw logo) and are copied into the Android project during the build.
