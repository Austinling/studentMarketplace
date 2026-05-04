import Image from "next/image";
import Link from "next/link";

interface AuthProps {
  type: "Login" | "Register";
}

export function AuthForm({ type }: AuthProps) {
  return (
    <div className="flex w-screen h-screen items-center justify-center">
      <div className="flex flex-col items-center justify-center h-auto w-auto p-10 shadow-2xl rounded-4xl gap-10 transition-all duration-500 ease-in-out">
        <div>
          <h3 className="text-4xl font-roboto">
            Welcome{type == "Register" ? "" : " Back"}!
          </h3>
        </div>
        <div className="flex flex-col gap-6">
          <input
            className="p-3 border-gray-200 border-2 w-80"
            type="text"
            placeholder="Email Address"
            name="username"
            required
          ></input>

          <div className="flex flex-col gap-3">
            <input
              className="p-3 border-gray-200 border-2 w-80"
              type="password"
              placeholder="Password"
              name="password"
              required
            ></input>
            {type == "Login" && (
              <div className="flex items-center justify-between">
                <div className="flex gap-2">
                  <input type="checkbox" />
                  <p>Remember for 30 days</p>
                </div>

                <p className="text-blue-400 underline text-right">
                  <Link href="/login">Forgot password?</Link>
                </p>
              </div>
            )}
          </div>

          {type == "Register" && (
            <input
              className="p-3 border-gray-200 border-2 w-80"
              type="password"
              placeholder="Confirm Password"
              name="confirmPassword"
              required
            ></input>
          )}
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

          <p className="text-blue-400 underline text-center">
            {type == "Register" ? (
              <Link href="/login">Already have an account? Sign In Now</Link>
            ) : (
              <Link href="/register">Don't have an account? Sign Up Now</Link>
            )}
          </p>
        </div>
      </div>
    </div>
  );
}
