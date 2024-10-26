import LandingPage from "./pages/LandingPage"

function App() {

  return <div>
      <BrowserRouter>
            <Routes>
                <Route path="/signup" element={<Signup/>}></Route>
                <Route path="/signin" element={<Signin/>}></Route>
                <Route path="/" element={<LandingPage children={undefined}/>}/>
            </Routes>
        </BrowserRouter>
    </div>
}

export default App
