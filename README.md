# Thai-Eng
import speech_recognition as sr
from pythainlp import word_tokenize

r = sr.Recognizer()
m = sr.Microphone()

with m as source: r.adjust_for_ambient_noise(source)
print("Set minimum energy threshold to {}".format(r.energy_threshold))
def checkspeech(r):
    with sr.Microphone() as source:
        audio = r.listen(source)
        #print("You said :" + r.recognize_google(audio, language="th-TH"))
    try:
        #print("You said : " + r.recognize_google(audio))      ###Eng-sub
        print("You said :" + r.recognize_google(audio, language="th-TH")) ### Thai
        print(word_tokenize(r.recognize_google(audio, language="th-TH"), engine='newmm'))
        return (r.recognize_google(audio, language="th-TH"))
    except sr.UnknownValueError:
        print("Google Speech Recognition could not understand audio")
        return ("WW")
    except sr.RequestError as e:
        print("Could not request results from Google Speech Recognition service; {0}".format(e))
        return ("WW")

speech = str(checkspeech(r))


