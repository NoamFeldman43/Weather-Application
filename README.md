# אפליקציה לחיוזי תחזית מזג האוויר בזמן אמת 🥇
## הקדמה
יישום זה של אנדרואיד משיג פרטי מזג האוויר עבור עיר נתונה באמצעות API של OpenWeatherMap ומציג את הטמפרטורה בצלזיוס.

## הוראות להרצת היישום

ודא שיש לך את Android Studio מותקן על המחשב המקומי שלך.
העתק או הורד את הפרויקט מהמקור שסופק.
פתח את הפרויקט ב-Android Studio.
חבר מכשיר אנדרואיד או השתמש באמולטור.
בנה והרץ את היישום על המכשיר המחובר או האמולטור.

## הסבר על הקוד
## קובץ פריסה XML (activity_main.xml):

מגדיר את פריסת מסך הפעילות הראשית.
מכיל TextView להצגת הכותרת "מזג האוויר", EditText להזנת שם העיר, Button לקבלת פרטי מזג האוויר, כפתור נוסף לניקוי הטקסט ב-EditText, ו-TextView להצגת תוצאת הטמפרטורה.
MainActivity.java:

## זהו קובץ הפעילות הראשי המטפל באינטראקציות של המשתמש ובבקשות ל-API.
מאתחל את האלמנטים EditText (etCity) ו-TextView (tvResult) בשיטת onCreate.
מגדיר שיטה getWeatherDetails כדי לקבל פרטי מזג האוויר כאשר המשתמש לוחץ על הכפתור "קבל".
משתמש בספריית Volley כדי לבצע שאילתה ל-API של OpenWeatherMap.
פותר את התגובה ה-JSON כדי לחלץ את הטמפרטורה ומציג אותה ב-TextView tvResult.
