import { useState } from 'react'
import { Plus, Trash2, Calculator } from 'lucide-react'

type Course = {
  id: number
  name: string
  grade: string
  credits: number
}

const gradePoints: { [key: string]: number } = {
  'A': 4.0, 'A-': 3.7, 'B+': 3.3, 'B': 3.0, 'B-': 2.7,
  'C+': 2.3, 'C': 2.0, 'C-': 1.7, 'D+': 1.3, 'D': 1.0, 'F': 0.0
}

export default function CGPACalculator() {
  const [courses, setCourses] = useState<Course[]>([
    { id: 1, name: '', grade: 'A', credits: 3 }
  ])
  const [cgpa, setCGPA] = useState<number | null>(null)

  const addCourse = () => {
    setCourses([...courses, { id: Date.now(), name: '', grade: 'A', credits: 3 }])
  }

  const removeCourse = (id: number) => {
    setCourses(courses.filter(course => course.id !== id))
  }

  const updateCourse = (id: number, field: keyof Course, value: string | number) => {
    setCourses(courses.map(course => 
      course.id === id ? { ...course, [field]: value } : course
    ))
  }

  const calculateCGPA = () => {
    let totalPoints = 0
    let totalCredits = 0

    courses.forEach(course => {
      const gradePoint = gradePoints[course.grade] || 0
      totalPoints += gradePoint * course.credits
      totalCredits += course.credits
    })

    const calculatedCGPA = totalCredits > 0 ? totalPoints / totalCredits : 0
    setCGPA(parseFloat(calculatedCGPA.toFixed(2)))
  }

  return (
    <div className="min-h-screen bg-black text-white p-8">
      <h1 className="text-4xl font-bold mb-8 text-center text-green-400">CGPA Calculator</h1>
      <div className="max-w-4xl mx-auto bg-blue-900/30 p-8 rounded-lg backdrop-blur-md border border-green-500/30">
        {courses.map((course, index) => (
          <div key={course.id} className="flex flex-wrap mb-4 -mx-2">
            <div className="w-full sm:w-1/3 px-2 mb-4 sm:mb-0">
              <input
                type="text"
                placeholder="Course Name"
                value={course.name}
                onChange={(e) => updateCourse(course.id, 'name', e.target.value)}
                className="w-full p-2 bg-black/50 border border-green-500/30 rounded text-white placeholder-gray-500 focus:border-green-500 focus:outline-none"
              />
            </div>
            <div className="w-full sm:w-1/3 px-2 mb-4 sm:mb-0">
              <select
                value={course.grade}
                onChange={(e) => updateCourse(course.id, 'grade', e.target.value)}
                className="w-full p-2 bg-black/50 border border-green-500/30 rounded text-white focus:border-green-500 focus:outline-none"
              >
                {Object.keys(gradePoints).map(grade => (
                  <option key={grade} value={grade}>{grade}</option>
                ))}
              </select>
            </div>
            <div className="w-full sm:w-1/4 px-2 mb-4 sm:mb-0">
              <input
                type="number"
                placeholder="Credits"
                value={course.credits}
                onChange={(e) => updateCourse(course.id, 'credits', parseInt(e.target.value) || 0)}
                className="w-full p-2 bg-black/50 border border-green-500/30 rounded text-white placeholder-gray-500 focus:border-green-500 focus:outline-none"
              />
            </div>
            <div className="w-full sm:w-auto px-2 flex items-center">
              <button
                onClick={() => removeCourse(course.id)}
                className="p-2 bg-red-500/20 text-red-400 rounded hover:bg-red-500/30 transition-colors"
              >
                <Trash2 size={20} />
              </button>
            </div>
          </div>
        ))}
        <div className="flex justify-between mt-6">
          <button
            onClick={addCourse}
            className="flex items-center px-4 py-2 bg-green-500 text-black rounded-full hover:bg-green-400 transition-colors"
          >
            <Plus size={20} className="mr-2" /> Add Course
          </button>
          <button
            onClick={calculateCGPA}
            className="flex items-center px-4 py-2 bg-blue-600 text-white rounded-full hover:bg-blue-500 transition-colors"
          >
            <Calculator size={20} className="mr-2" /> Calculate CGPA
          </button>
        </div>
        {cgpa !== null && (
          <div className="mt-8 text-center">
            <h2 className="text-2xl font-bold text-green-400">Your CGPA</h2>
            <p className="text-4xl font-bold mt-2">{cgpa}</p>
          </div>
        )}
      </div>
    </div>
  )
}