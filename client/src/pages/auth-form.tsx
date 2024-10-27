import React, { useState } from 'react'
import { User, Mail, Lock, Eye, EyeOff, ArrowRight, UserPlus, LogIn } from 'lucide-react'

type AuthMode = 'signup' | 'signin'

export default function AuthForm() {
  const [mode, setMode] = useState<AuthMode>('signin')
  const [showPassword, setShowPassword] = useState(false)
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  })

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value })
  }

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    // Here you would typically send the form data to your backend
    console.log('Form submitted:', formData)
  }

  const toggleMode = () => {
    setMode(mode === 'signin' ? 'signup' : 'signin')
    setFormData({ name: '', email: '', password: '' })
  }

  return (
    <div className="min-h-screen bg-black text-white flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <div className="bg-blue-900/30 p-8 rounded-lg backdrop-blur-md border border-green-500/30">
          <h2 className="text-3xl font-bold mb-6 text-center text-green-400">
            {mode === 'signin' ? 'Sign In' : 'Sign Up'} to GradeChecker
          </h2>
          <form onSubmit={handleSubmit} className="space-y-6">
            {mode === 'signup' && (
              <div>
                <label htmlFor="name" className="block text-sm font-medium text-gray-300 mb-1">
                  Full Name
                </label>
                <div className="relative">
                  <input
                    type="text"
                    id="name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    className="w-full px-4 py-2 bg-black/50 border border-green-500/30 rounded text-white placeholder-gray-500 focus:border-green-500 focus:ring-1 focus:ring-green-500 focus:outline-none pl-10"
                    placeholder="John Doe"
                    required
                  />
                  <User className="absolute left-3 top-2.5 text-gray-400" size={18} />
                </div>
              </div>
            )}
            <div>
              <label htmlFor="email" className="block text-sm font-medium text-gray-300 mb-1">
                Email Address
              </label>
              <div className="relative">
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  className="w-full px-4 py-2 bg-black/50 border border-green-500/30 rounded text-white placeholder-gray-500 focus:border-green-500 focus:ring-1 focus:ring-green-500 focus:outline-none pl-10"
                  placeholder="you@example.com"
                  required
                />
                <Mail className="absolute left-3 top-2.5 text-gray-400" size={18} />
              </div>
            </div>
            <div>
              <label htmlFor="password" className="block text-sm font-medium text-gray-300 mb-1">
                Password
              </label>
              <div className="relative">
                <input
                  type={showPassword ? 'text' : 'password'}
                  id="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  className="w-full px-4 py-2 bg-black/50 border border-green-500/30 rounded text-white placeholder-gray-500 focus:border-green-500 focus:ring-1 focus:ring-green-500 focus:outline-none pl-10 pr-10"
                  placeholder="••••••••"
                  required
                />
                <Lock className="absolute left-3 top-2.5 text-gray-400" size={18} />
                <button
                  type="button"
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute right-3 top-2.5 text-gray-400 focus:outline-none"
                >
                  {showPassword ? <EyeOff size={18} /> : <Eye size={18} />}
                </button>
              </div>
            </div>
            <button
              type="submit"
              className="w-full bg-green-500 text-black font-bold py-2 px-4 rounded-full hover:bg-green-400 transition-colors flex items-center justify-center"
            >
              {mode === 'signin' ? (
                <>
                  Sign In <ArrowRight className="ml-2" size={18} />
                </>
              ) : (
                <>
                  Sign Up <UserPlus className="ml-2" size={18} />
                </>
              )}
            </button>
          </form>
          <div className="mt-6 text-center">
            <p className="text-gray-400">
              {mode === 'signin' ? "Don't have an account?" : "Already have an account?"}
            </p>
            <button
              onClick={toggleMode}
              className="mt-2 text-green-400 hover:text-green-300 transition-colors focus:outline-none"
            >
              {mode === 'signin' ? 'Create an account' : 'Sign in to your account'}
            </button>
          </div>
        </div>
        <div className="mt-8 text-center">
          <p className="text-sm text-gray-400">
            By signing {mode === 'signin' ? 'in' : 'up'}, you agree to our{' '}
            <a href="#" className="text-green-400 hover:text-green-300">
              Terms of Service
            </a>{' '}
            and{' '}
            <a href="#" className="text-green-400 hover:text-green-300">
              Privacy Policy
            </a>
            .
          </p>
        </div>
      </div>
    </div>
  )
}