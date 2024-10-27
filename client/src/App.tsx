import CGPACalculator from "./pages/CGPACalculator"
import Dashboard from "./pages/Dasahboard"
import LandingPage from "./pages/LandingPage"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import ProfilePage from "./pages/Profilepage"
import AuthForm from "./pages/auth-form"
function App() {

  return <div>
      <BrowserRouter>
            <Routes>
                <Route path="/auth" element={<AuthForm  />}/>
                <Route path="/" element={<LandingPage/>}/>
                <Route path="/cgpa-calculator" element={<CGPACalculator/>}/>
                <Route path="/dashboard" element={<Dashboard/>}/>
                <Route path="/profile" element={<ProfilePage/>}/>

            </Routes>
        </BrowserRouter>
    </div>
}

export default App
