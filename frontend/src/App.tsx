import { useState } from 'react'
import './App.css'

function App() {

  const [text, setText] = useState('');
  const [result, setResult] = useState('');
  const [wordCount, setWordCount] = useState(0);

  const onClick = () => {
    const data = { text }
    fetch('/api/essay/proofreading', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('error')
      }
      return response.json();
    })
    .then(data => {
        setResult(data.result);
    })
    .catch(error => {
        console.error('Error:', error);
    })
  }

  const handleChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    const inputText = e.target.value;
    setText(inputText);
    const wordCount = countWords(inputText);
    setWordCount(wordCount)
  }

  const countWords = (text: string) => {
    return text.trim().split(/\s+/).filter(word => word.length > 0).length;
  }

  const disabled = text.length == 0;

  return (
    <>
      <h1>My Essay App</h1>
      <textarea value={text} onChange={handleChange}/>
      <div>word count: {wordCount}/300</div>
      <button onClick={onClick} disabled={disabled}>添削する</button>
      <div>{result}</div>
    </>
  )
}

export default App
