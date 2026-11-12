# VEDIC WISDOM — International Vastu & Astro-Vastu Web Platform

> **"Traditional Wisdom. Analytical Thinking. Practical Awareness."**  
> *International Vastu Consultancy | Astro-Vastu Consultancy | KP Astrology | Vastu Education & Research*

[![Deploy with Vercel](https://vercel.com/button)](https://vercel.com/new)

---

## 🏛️ Project Overview

**Vedic Wisdom** is a premier, luxury corporate web application for an international Vastu and Astro-Vastu consultancy headquartered in Bhopal, Madhya Pradesh, India. Built with modern, eye-friendly aesthetics, the platform combines traditional Vedic principles with analytical clarity and practical non-demolition solutions.

### 🌟 Key Highlights
- **Executive Luxury Design**: Built with an eye-friendly Cashmere Ivory (`#F5F3EE`) & Pearl Soft canvas, rich velvet typography, and warm champagne gold accents.
- **Interactive Day ☀️ / Night 🌙 Switcher**: Effortless theme switching with zero glare.
- **Dual Currency Support**: All 6 consultation tiers, comparison tables, and academy programs display both **₹ INR** and **$ USD** simultaneously.
- **Interactive Vastu Directional Compass**: 8-direction analyzer with deity attributes and Panchtatva elemental mapping (Water, Air, Fire, Earth, Space).
- **Consultation Booking Engine**: Client intake form with dynamic reference ID generation (`#VW-XXXX`) and compliant manual confirmation status.
- **Zero-Build Architecture**: Runs instantly with React 18 and Tailwind CSS CDN, ensuring 100% uptime with zero build failures or complex npm dependency maintenance.

---

## 🚀 How to Publish to GitHub & Vercel

### Step 1: Push Code to GitHub

1. Open your terminal in this project root:
   ```bash
   git add .
   git commit -m "feat: complete production-ready Vedic Wisdom platform"
   git branch -M main
   ```

2. Create a new repository on [GitHub](https://github.com/new) named `Vedic-Wisdom` (or your preferred name).

3. Link and push your local code:
   ```bash
   git remote add origin https://github.com/YOUR_GITHUB_USERNAME/Vedic-Wisdom.git
   git push -u origin main
   ```

---

### Step 2: Deploy to Vercel

#### Option A: Connect via Vercel Dashboard (Recommended)
1. Go to [vercel.com](https://vercel.com) and log in with your GitHub account.
2. Click **"Add New Project"** and select **"Continue with GitHub"**.
3. Choose your `Vedic-Wisdom` repository from the list.
4. Keep the default settings (Framework Preset: **Other** / Root Directory: `./`).
5. Click **"Deploy"**.
6. Within 15 seconds, your site is live with a free global SSL domain (e.g., `https://vedic-wisdom.vercel.app`)!

#### Option B: Deploy via Vercel CLI (Direct from Terminal)
If you prefer deploying directly from your computer terminal:
```bash
# Preview Deployment
npx vercel

# Production Deployment
npx vercel --prod
```
Follow the simple on-screen prompts to log in and confirm deployment.

---

### Step 3: (Optional) Deploy via GitHub Pages
Since this platform is zero-dependency static HTML5/React:
1. In your GitHub repository, go to **Settings** > **Pages**.
2. Under **Build and deployment** > **Branch**, select `main` and `/ (root)`.
3. Click **Save**.
4. Your site will be live at `https://YOUR_GITHUB_USERNAME.github.io/Vedic-Wisdom/`.

---

## 📁 Repository Structure

```text
Vedic-Wisdom/
├── index.html              # Root production entry point (GitHub Pages & Vercel default)
├── vercel.json             # Vercel security headers and clean URL routing configuration
├── README.md               # Complete project and deployment documentation
├── .gitignore              # Ignored files (node_modules, credentials, builds)
├── web/
│   ├── index.html          # Modular web source code
│   ├── package.json        # Web metadata and local serve scripts
│   └── vercel.json         # Standalone directory deployment config
└── app/                    # Companion Android native application (Jetpack Compose)
```

---

## ⚖️ Legal Compliance & Disclaimers

- **Non-Demolition Philosophy**: Vastu recommendations prioritize spatial energy alignment, color balancing, and elemental adjustments without destructive structural demolition whenever possible. Recommendations depend on site conditions.
- **Professional Advisory Notice**: Vastu and KP Astrology consultations offer supportive spatial and personal energetic alignment. They do not replace licensed medical, structural engineering, legal, or chartered financial counsel.
- **Booking Policy**: All digital submissions generate an enquiry reference code with status *"Enquiry Received – Pending Manual Confirmation"* until verified by our desk.

---

## 📞 Contact & Inquiries

- **HQ**: Bhopal, Madhya Pradesh, India
- **Phone**: +91 90094 48601
- **Email**: ask.vedicwisdom@gmail.com
- **Website**: [vedicwisdom.in](https://vedicwisdom.in)
