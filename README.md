# CivicBridge Login Page — School Project

## Files
- `login.html`: Responsive login interface (resident and employee tabs).
- `CivicBridge_App_Demo.html`: Existing six-screen CivicBridge prototype, launched by the login page.

## Open and test
1. Keep both HTML files in the same directory.
2. Open `login.html` in Chrome, Edge, or Firefox.
3. Choose Resident or City Employee.
4. Click **Fill in demo credentials**, then **Sign in to CivicBridge**.
5. The prototype opens in the selected workspace. Use **Sign out** to return to login.

Resident sample: `resident@civicbridge.demo` / `Demo123!`
Employee sample: `staff@civicbridge.demo` / `Demo123!`

## Important security note
This is **a front-end class prototype, not real authentication**. Demo passwords are visible in the HTML source. Browser session storage is used only to demonstrate navigation. Roles are not secured, there is no account database, and the prototype data is fictional. **Never use this login page with real citizens, real employees, real passwords, or sensitive data.**

## Converting to real login with Node.js, Express, and SQLite
- Create a server-side `users` table with `id`, `email`, `password_hash`, `role`, and timestamps.
- Use Argon2id (or a reputable password hashing implementation) for passwords; never store plaintext passwords.
- Build an HTTPS `/api/login` endpoint with server-side validation, rate limiting, and generic error responses.
- Use secure, HttpOnly, SameSite session cookies and enforce resident/staff authorization server-side for every API request.
- Protect database queries with parameters and apply CSRF protection where relevant.
- Build a real password reset flow using expiring single-use tokens.
- Remove all demo credentials and front-end role checks before deployment.

**Note:** The existing high-fidelity app still includes role-switch controls from the earlier prototype for design review. They do **not** represent access controls.
