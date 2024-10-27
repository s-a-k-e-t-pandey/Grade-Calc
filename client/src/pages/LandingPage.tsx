import { useEffect, useState } from "react"
import {Link} from "react-router-dom"
import { ArrowRight, BookOpen, GraduationCap, TrendingUp, Users } from "lucide-react"

export default function LandingPage() {
  const [scrolled, setScrolled] = useState(false)

  useEffect(() => {
    const handleScroll = () => {
      setScrolled(window.scrollY > 20)
    }
    window.addEventListener("scroll", handleScroll)
    return () => window.removeEventListener("scroll", handleScroll)
  }, [])

  return (
    <div className="min-h-screen bg-black text-white">
      <header className={`fixed w-full z-10 transition-all duration-300 ${scrolled ? 'bg-black/80 backdrop-blur-md' : 'bg-transparent'}`}>
        <nav className="container mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <Link to="/" className="flex items-center space-x-2 text-2xl font-bold text-green-400">
              <GraduationCap size={32} />
              <span>GradeChecker</span>
            </Link>
            <div className="hidden md:flex space-x-6">
              <Link to="#features" className="hover:text-green-400 transition-colors">Features</Link>
              <Link to="#about" className="hover:text-green-400 transition-colors">About</Link>
              <Link to="#contact" className="hover:text-green-400 transition-colors">Contact</Link>
            </div>
            <div className="space-x-4">
              <Link to="/auth" className="px-4 py-2 rounded bg-blue-600 hover:bg-blue-500 transition-colors">
                Log In
              </Link>
              <Link to="/auth" className="px-4 py-2 rounded bg-green-500 text-black hover:bg-green-400 transition-colors">
                Sign Up
              </Link>
            </div>
          </div>
        </nav>
      </header>

      <main>
        <section className="relative h-screen flex items-center justify-center overflow-hidden">
          <div className="absolute inset-0 z-0">
            <div className="absolute inset-0 bg-gradient-to-br from-blue-900 via-black to-green-900 opacity-50"></div>
            <div className="absolute inset-0 bg-[url('/abstract-bg.jpg')] bg-cover bg-center mix-blend-overlay"></div>
          </div>
          <div className="relative z-10 text-center px-4">
            <h1 className="text-5xl md:text-7xl font-bold mb-6 animate-fade-in-up">
              Track Your <span className="text-green-400">Academic Success</span>
            </h1>
            <p className="text-xl md:text-2xl mb-12 max-w-2xl mx-auto animate-fade-in-up animation-delay-300">
              GradeChecker helps you monitor your grades, calculate your GPA, and stay on top of your academic performance.
            </p>
            <Link 
              to="/dashboard"
              className="inline-flex items-center px-8 py-4 rounded-full bg-green-500 text-black hover:bg-green-400 transition-colors text-lg font-semibold animate-fade-in-up animation-delay-600"
            >
              Get Started
              <ArrowRight className="ml-2" size={20} />
            </Link>
          </div>
        </section>

        <section id="features" className="py-20 bg-gradient-to-b from-black to-blue-900">
          <div className="container mx-auto px-4">
            <h2 className="text-3xl md:text-5xl font-bold mb-12 text-center text-green-400">Key Features</h2>
            <div className="grid md:grid-cols-3 gap-8">
              <div className="bg-black/50 p-8 rounded-lg shadow-lg backdrop-blur-md border border-green-500/30 hover:border-green-500 transition-all duration-300">
                <BookOpen size={48} className="mb-4 text-blue-400" />
                <h3 className="text-2xl font-semibold mb-4 text-green-400">Grade Tracking</h3>
                <p className="text-gray-300">Easily input and monitor your grades for all your courses in one place.</p>
              </div>
              <div className="bg-black/50 p-8 rounded-lg shadow-lg backdrop-blur-md border border-green-500/30 hover:border-green-500 transition-all duration-300">
                <TrendingUp size={48} className="mb-4 text-blue-400" />
                <h3 className="text-2xl font-semibold mb-4 text-green-400">GPA Calculator</h3>
                <p className="text-gray-300">Automatically calculate your GPA and track your academic progress over time.</p>
              </div>
              <div className="bg-black/50 p-8 rounded-lg shadow-lg backdrop-blur-md border border-green-500/30 hover:border-green-500 transition-all duration-300">
                <Users size={48} className="mb-4 text-blue-400" />
                <h3 className="text-2xl font-semibold mb-4 text-green-400">Performance Insights</h3>
                <p className="text-gray-300">Get valuable insights into your academic performance and areas for improvement.</p>
              </div>
            </div>
          </div>
        </section>

        <section id="about" className="py-20 bg-gradient-to-b from-blue-900 to-black">
          <div className="container mx-auto px-4">
            <h2 className="text-3xl md:text-5xl font-bold mb-6 text-center text-green-400">About GradeChecker</h2>
            <p className="text-xl text-center max-w-3xl mx-auto mb-12 text-gray-300">
              GradeChecker was created by students, for students. Our mission is to help you achieve your academic goals
              by providing powerful tools to track and analyze your performance.
            </p>
            <div className="bg-black/50 p-8 rounded-lg shadow-lg backdrop-blur-md border border-green-500/30 max-w-2xl mx-auto">
              <blockquote className="text-lg italic text-gray-300">
                "GradeChecker has completely transformed how I manage my studies. It's an essential tool for any serious student."
              </blockquote>
              <p className="mt-4 font-semibold text-green-400">- Sarah J., Computer Science Major</p>
            </div>
          </div>
        </section>

        <section id="contact" className="py-20 bg-gradient-to-b from-black to-blue-900">
          <div className="container mx-auto px-4">
            <h2 className="text-3xl md:text-5xl font-bold mb-12 text-center text-green-400">Get in Touch</h2>
            <form className="max-w-lg mx-auto">
              <div className="mb-6">
                <label htmlFor="name" className="block mb-2 font-semibold text-gray-300">Name</label>
                <input 
                  type="text" 
                  id="name" 
                  className="w-full px-4 py-2 rounded bg-black/50 border border-green-500/30 focus:border-green-500 focus:outline-none text-white"
                  placeholder="Your name"
                />
              </div>
              <div className="mb-6">
                <label htmlFor="email" className="block mb-2 font-semibold text-gray-300">Email</label>
                <input 
                  type="email" 
                  id="email" 
                  className="w-full px-4 py-2 rounded bg-black/50 border border-green-500/30 focus:border-green-500 focus:outline-none text-white"
                  placeholder="your@email.com"
                />
              </div>
              <div className="mb-6">
                <label htmlFor="message" className="block mb-2 font-semibold text-gray-300">Message</label>
                <textarea 
                  id="message" 
                  rows={4}
                  className="w-full px-4 py-2 rounded bg-black/50 border border-green-500/30 focus:border-green-500 focus:outline-none text-white"
                  placeholder="Your message"
                ></textarea>
              </div>
              <button 
                type="submit" 
                className="w-full px-6 py-3 rounded-full bg-green-500 text-black hover:bg-green-400 transition-colors font-semibold"
              >
                Send Message
              </button>
            </form>
          </div>
        </section>
      </main>

      <footer className="bg-black py-8 border-t border-green-500/30">
        <div className="container mx-auto px-4">
          <div className="flex flex-col md:flex-row justify-between items-center">
            <div className="mb-4 md:mb-0">
              <Link to="/" className="flex items-center space-x-2 text-xl font-bold text-green-400">
                <GraduationCap size={24} />
                <span>GradeChecker</span>
              </Link>
            </div>
            <nav className="flex space-x-4 mb-4 md:mb-0">
              <Link to="#features" className="text-gray-300 hover:text-green-400 transition-colors">Features</Link>
              <Link to="#about" className="text-gray-300 hover:text-green-400 transition-colors">About</Link>
              <Link to="#contact" className="text-gray-300 hover:text-green-400 transition-colors">Contact</Link>
            </nav>
            <div className="text-sm text-gray-500">
              © 2024 GradeChecker. All rights reserved.
            </div>
          </div>
        </div>
      </footer>
    </div>
  )
}