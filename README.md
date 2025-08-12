# DoodhKaHisab - Ready-to-push Android Project

This repository is prepared to be pushed to GitHub. It contains:
- Kotlin + XML Android app (minimal)
- Room database, ViewModel, SharedPreferences for default milk price
- Gradle project & module files
- `gradlew` and `gradlew.bat` scripts + gradle/wrapper/gradle-wrapper.properties
  (Note: gradle-wrapper.jar is **not** included here to avoid large binary; CI workflow uses a Gradle action to run Gradle.)
- GitHub Actions workflow to build APK on each push and upload artifact (downloadable from Actions run)

Steps to use:
1. Unzip and open in Android Studio.
2. If Android Studio asks to add Gradle wrapper or update plugin, accept recommended changes.
3. Create a new **empty repo** on GitHub.
4. From the project root:
   ```
   git init
   git add .
   git commit -m "Initial commit - DoodhKaHisab"
   git branch -M main
   git remote add origin https://github.com/<your-username>/<repo>.git
   git push -u origin main
   ```
5. Go to GitHub → Actions → select the workflow run → wait for build → download APK artifact.

If you want me to include the actual gradle-wrapper.jar as well (fully self-contained), tell me and I'll add it.  
