import Image from "next/image";

export function Login() {
  return (
    <div className="flex w-screen h-screen items-center justify-center">
      <div className="flex flex-col items-center justify-center w-96 h-120 shadow-2xl rounded-4xl gap-10">
        <div>
          <h3 className="text-4xl font-roboto">Welcome Back!</h3>
        </div>
        <div className="flex flex-col gap-6">
          <input
            className="p-3 border-gray-200 border-2 w-80"
            type="text"
            placeholder="Email Address"
            name="uname"
            required
          ></input>

          <input
            className="p-3 border-gray-200 border-2 w-80"
            type="password"
            placeholder="Password"
            name="psw"
            required
          ></input>
        </div>
        <div className="flex flex-col gap-2">
          <button className="p-3 w-80 border bg-black text-white">
            Sign In
          </button>
          <button className="p-1 w-80 flex items-center justify-center gap-2 border-gray-200 border-2">
            <Image
              className=""
              src="/google.svg"
              alt="Google Logo"
              width={40}
              height={40}
              priority
            />
            Sign In With Google
          </button>
        </div>
      </div>
    </div>
  );
}
