import {Link} from "react-router-dom"
import { BarChart, BookOpen, GraduationCap, TrendingUp, User, LogOut } from 'lucide-react'

const courses = [
  { id: 1, name: 'Mathematics', grade: 'A', progress: 90 },
  { id: 2, name: 'Physics', grade: 'B+', progress: 85 },
  { id: 3, name: 'Computer Science', grade: 'A-', progress: 88 },
  { id: 4, name: 'Literature', grade: 'B', progress: 78 },
]

export default function Dashboard() {
  return (
    <div className="min-h-screen bg-black text-white">
      <div className="flex">
        {/* Sidebar */}
        <aside className="w-64 bg-blue-900/30 min-h-screen p-4">
          <div className="flex items-center mb-8">
            <GraduationCap size={32} className="text-green-400 mr-2" />
            <span className="text-xl font-bold text-green-400">GradeChecker</span>
          </div>
          <nav>
            <Link to="/dashboard" className="flex items-center text-white hover:text-green-400 mb-4">
              <BarChart size={20} className="mr-2" /> Dashboard
            </Link>
            <Link to="/courses" className="flex items-center text-white hover:text-green-400 mb-4">
              <BookOpen size={20} className="mr-2" /> Courses
            </Link>
            <Link to="/cgpa-calculator" className="flex items-center text-white hover:text-green-400 mb-4">
              <TrendingUp size={20} className="mr-2" /> CGPA Calculator
            </Link>
            <Link to="/profile" className="flex items-center text-white hover:text-green-400 mb-4">
              <User size={20} className="mr-2" /> Profile
            </Link>
          </nav>
        </aside>

        {/* Main content */}
        <main className="flex-1 p-8">
          <div className="flex justify-between items-center mb-8">
            <h1 className="text-3xl font-bold text-green-400">Dashboard</h1>
            <button className="flex items-center px-4 py-2 bg-red-500/20 text-red-400 rounded hover:bg-red-500/30 transition-colors">
              <LogOut size={20} className="mr-2" /> Logout
            </button>
          </div>

          {/* CGPA Card */}
          <div className="bg-blue-900/30 p-6 rounded-lg backdrop-blur-md border border-green-500/30 mb-8">
            <h2 className="text-xl font-bold mb-2 text-green-400">Current CGPA</h2>
            <p className="text-4xl font-bold">3.75</p>
          </div>

          {/* Courses Grid */}
          <h2 className="text-2xl font-bold mb-4 text-green-400">Your Courses</h2>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {courses.map(course => (
              <div key={course.id} className="bg-blue-900/30 p-6 rounded-lg backdrop-blur-md border border-green-500/30">
                <h3 className="text-lg font-bold mb-2">{course.name}</h3>
                <p className="mb-2">Grade: <span className="text-green-400 font-bold">{course.grade}</span></p>
                <div className="relative pt-1">
                  <div className="flex mb-2 items-center justify-between">
                    <div>
                      <span className="text-xs font-semibold inline-block py-1 px-2 uppercase rounded-full text-green-400 bg-green-200">
                        Progress
                      </span>
                    </div>
                    <div className="text-right">
                      <span className="text-xs font-semibold inline-block text-green-400">
                        {course.progress}%
                      </span>
                    </div>
                  </div>
                  <div className="overflow-hidden h-2 mb-4 text-xs flex rounded bg-green-200">
                    <div style={{ width: `${course.progress}%` }} className="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-green-500"></div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </main>
      </div>
    </div>
  )
}