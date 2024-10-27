import React, { useState } from 'react'
import { 
  User, Edit, Mail, Phone, MapPin, Book, Award, 
  TrendingUp, Bell, Shield, CreditCard, ChevronRight, 
  CheckCircle, Star
} from 'lucide-react'

export default function ProfilePage() {
  const [isEditing, setIsEditing] = useState(false)
  const [profile, setProfile] = useState({
    name: 'Alex Johnson',
    email: 'alex.johnson@example.com',
    phone: '+1 (555) 123-4567',
    location: 'New York, NY',
    major: 'Computer Science',
    year: 'Junior',
    gpa: '3.8'
  })

  const handleEdit = () => {
    setIsEditing(!isEditing)
  }

  const handleSave = () => {
    // Here you would typically send the updated profile to your backend
    setIsEditing(false)
  }

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setProfile({ ...profile, [e.target.name]: e.target.value })
  }

  return (
    <div className="min-h-screen bg-black text-white p-8">
      <div className="max-w-4xl mx-auto">
        <h1 className="text-4xl font-bold mb-8 text-center text-green-400">Your Profile</h1>
        
        <div className="bg-blue-900/30 p-8 rounded-lg backdrop-blur-md border border-green-500/30 mb-8">
          <div className="flex justify-between items-start mb-6">
            <div className="flex items-center">
              <div className="w-24 h-24 bg-green-500 rounded-full flex items-center justify-center text-4xl font-bold text-black mr-6">
                {profile.name.charAt(0)}
              </div>
              <div>
                <h2 className="text-2xl font-bold text-green-400">{profile.name}</h2>
                <p className="text-blue-300">{profile.major} - {profile.year}</p>
              </div>
            </div>
            <button 
              onClick={handleEdit} 
              className="bg-green-500 text-black px-4 py-2 rounded-full hover:bg-green-400 transition-colors flex items-center"
            >
              {isEditing ? 'Cancel' : 'Edit Profile'}
              {isEditing ? <X className="ml-2" size={18} /> : <Edit className="ml-2" size={18} />}
            </button>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div className="space-y-4">
              <div className="flex items-center">
                <Mail className="text-green-400 mr-2" size={20} />
                {isEditing ? (
                  <input 
                    type="email" 
                    name="email" 
                    value={profile.email} 
                    onChange={handleChange}
                    className="bg-black/50 border border-green-500/30 rounded p-2 w-full"
                  />
                ) : (
                  <span>{profile.email}</span>
                )}
              </div>
              <div className="flex items-center">
                <Phone className="text-green-400 mr-2" size={20} />
                {isEditing ? (
                  <input 
                    type="tel" 
                    name="phone" 
                    value={profile.phone} 
                    onChange={handleChange}
                    className="bg-black/50 border border-green-500/30 rounded p-2 w-full"
                  />
                ) : (
                  <span>{profile.phone}</span>
                )}
              </div>
              <div className="flex items-center">
                <MapPin className="text-green-400 mr-2" size={20} />
                {isEditing ? (
                  <input 
                    type="text" 
                    name="location" 
                    value={profile.location} 
                    onChange={handleChange}
                    className="bg-black/50 border border-green-500/30 rounded p-2 w-full"
                  />
                ) : (
                  <span>{profile.location}</span>
                )}
              </div>
            </div>
            <div className="space-y-4">
              <div className="flex items-center">
                <Book className="text-green-400 mr-2" size={20} />
                <span>Major: {profile.major}</span>
              </div>
              <div className="flex items-center">
                <Award className="text-green-400 mr-2" size={20} />
                <span>Year: {profile.year}</span>
              </div>
              <div className="flex items-center">
                <TrendingUp className="text-green-400 mr-2" size={20} />
                <span>GPA: {profile.gpa}</span>
              </div>
            </div>
          </div>

          {isEditing && (
            <div className="mt-6 flex justify-end">
              <button 
                onClick={handleSave} 
                className="bg-blue-600 text-white px-6 py-2 rounded-full hover:bg-blue-500 transition-colors"
              >
                Save Changes
              </button>
            </div>
          )}
        </div>

        <div className="bg-blue-900/30 p-8 rounded-lg backdrop-blur-md border border-green-500/30">
          <h3 className="text-2xl font-bold mb-6 text-green-400">Premium Features</h3>
          <div className="space-y-4">
            <div className="flex items-center justify-between p-4 bg-black/30 rounded-lg">
              <div className="flex items-center">
                <Bell className="text-yellow-400 mr-4" size={24} />
                <span>Grade Alerts</span>
              </div>
              <ChevronRight className="text-green-400" size={20} />
            </div>
            <div className="flex items-center justify-between p-4 bg-black/30 rounded-lg">
              <div className="flex items-center">
                <Shield className="text-yellow-400 mr-4" size={24} />
                <span>Advanced Analytics</span>
              </div>
              <ChevronRight className="text-green-400" size={20} />
            </div>
            <div className="flex items-center justify-between p-4 bg-black/30 rounded-lg">
              <div className="flex items-center">
                <CreditCard className="text-yellow-400 mr-4" size={24} />
                <span>Unlimited Course Tracking</span>
              </div>
              <ChevronRight className="text-green-400" size={20} />
            </div>
          </div>
          <div className="mt-6">
            <button className="w-full bg-gradient-to-r from-yellow-400 to-yellow-600 text-black font-bold py-3 px-6 rounded-full hover:from-yellow-500 hover:to-yellow-700 transition-colors flex items-center justify-center">
              <Star className="mr-2" size={20} />
              Upgrade to Premium
            </button>
          </div>
        </div>

        <div className="mt-8 text-center">
          <p className="text-blue-300">
            <CheckCircle className="inline-block mr-2 text-green-400" size={20} />
            Your account is verified and secure
          </p>
        </div>
      </div>
    </div>
  )
}