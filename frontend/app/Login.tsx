export function Login() {
  return (
    <div className="flex items-center justify-center">
      <div className="flex flex-col items-center justify-center w-100 h-100 shadow-2xl rounded-4xl">
        <div className="flex flex-col">
          <label htmlFor="uname">
            <b>Username</b>
          </label>
          <input
            type="text"
            placeholder="Enter Username"
            name="uname"
            required
          ></input>
        </div>

        <div>
          <label htmlFor="psw">
            <b>Password</b>
          </label>
          <input
            type="password"
            placeholder="Enter Password"
            name="psw"
            required
          ></input>
        </div>
      </div>
    </div>
  );
}
