# Build the Winter Arc APK from your phone

This project includes `.github/workflows/build-apk.yml`.

1. Create a GitHub repository and upload all files/folders from this project.
2. Open the repository's **Actions** tab.
3. Select **Build Winter Arc APK**.
4. Tap **Run workflow** (the workflow also runs automatically on pushes to `main` or `master`).
5. Wait for the job to finish successfully.
6. Open the completed workflow run and scroll to **Artifacts**.
7. Download **WinterArc-debug-apk** and extract the ZIP to get `app-debug.apk`.
8. On your Android phone, open the APK and allow installation from that source if Android asks.

The workflow builds a debug APK, which is suitable for installing/testing on your own phone. It is not a Play Store release build.
