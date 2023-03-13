function App() {
	return (
		<div className='min-h-screen'>
			<div className='flex justify-between items-center relative bg-purple-600 text-white'>
				<div className='font-sans p-4'>Home</div>
				<div className='font-sans p-4 bg-purple-700'>Login</div>
			</div>

			<div className='grid justify-items-center content-center'>
				<p className='text-white w-[700px] m-4 mt-5 text-xl font-serif'>
					Hi! I'm Amos. I make long articles and videos about how computers work
					— well, how they sometimes work. My content is long-form, didactic and
					exploratory, and often an excuse to teach Rust.
				</p>
                <div className="flex items-baseline gap-3 w-[600px] py-3 font-extrabold text-gray-100 text-2xl">
                    <span>Recent Articles</span>
                    <span className="text-xl font-bold text-gray-300 hover:underline underline-offset-4 cursor-pointer">&gt;&gt; View All</span>
                </div>
				<div className='w-[600px]'>
					<div className='p-2 grid gap-3 justify-items-center'>
						<div className='w-full bg-zinc-900 p-5 rounded-lg font-serif'>
							<a className='text-2xl font-bold text-zinc-100'>
								Twitch Fell Behind
							</a>
							<div className='flex py-2 text-zinc-500'>
								<span>Mar 13 '23</span>
								<span>X minute read</span>
								<span>tag · tag</span>
							</div>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<div className='flex justify-end'>
								<div className='mt-3 px-3 py-2 font-sans font-bold text-white rounded-lg bg-zinc-800'>
									Read More
								</div>
							</div>
						</div>
						<div className='w-full bg-zinc-900 p-5 rounded-lg font-serif'>
							<a className='text-2xl font-bold text-zinc-100'>
								Twitch Fell Behind
							</a>
							<div className='flex py-2 text-zinc-500'>
								<span>Mar 13 '23</span>
								<span>X minute read</span>
								<span>tag · tag</span>
							</div>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<div className='flex justify-end'>
								<div className='mt-3 px-3 py-2 font-sans font-bold text-white rounded-lg bg-zinc-800'>
									Read More
								</div>
							</div>
						</div>
						<div className='w-full bg-zinc-900 p-5 rounded-lg font-serif'>
							<a className='text-2xl font-bold text-zinc-100'>
								Twitch Fell Behind
							</a>
							<div className='flex py-2 text-zinc-500'>
								<span>Mar 13 '23</span>
								<span>X minute read</span>
								<span>tag · tag</span>
							</div>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<p className='text-zinc-100 py-3 text-lg'>
								Lorem ipsum dolor sit amet consectetur, adipisicing elit.{' '}
							</p>
							<div className='flex justify-end'>
								<div className='mt-3 px-3 py-2 font-sans font-bold text-white rounded-lg bg-zinc-800'>
									Read More
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	)
}

export default App
